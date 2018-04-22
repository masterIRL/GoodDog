package model;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import javax.swing.JOptionPane;

import static java.nio.file.StandardWatchEventKinds.*;

public class modeOuvertThread extends Thread{

	private boolean actif = true;
	private String s;

	public modeOuvertThread(String s) {
		super(s);
		this.s = s;
	}

	public void arret() {
		this.actif = false;
	}

	public void run()  {

		do {

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt(); // Très important de réinterrompre
				break;
			}

			try {

				WatchService watcher = FileSystems.getDefault().newWatchService(); //declaration du watcheur
				Path dir = Paths.get(this.s); //chemin 
				try {
					WatchKey key = dir.register(watcher,
							ENTRY_CREATE,
							ENTRY_DELETE,
							ENTRY_MODIFY);
				} catch (IOException x) {
					System.err.println(x);
				}

				//while(this.actif) {
				// wait for key to be signaled
				WatchKey key;
				try {
					key = watcher.take();
				} catch (InterruptedException x) {
					return;
				}

				for (WatchEvent<?> event: key.pollEvents()) {
					WatchEvent.Kind<?> kind = event.kind();

					if (kind == OVERFLOW) {
						continue;
					}

					@SuppressWarnings("unchecked")

					// The filename is the
					// context of the event.
					WatchEvent<Path> ev = (WatchEvent<Path>)event;
					Path fileName = ev.context();

					if(kind == ENTRY_CREATE) {
						new JOptionPane();
						//Boîte du message d'information
						JOptionPane.showMessageDialog(null, "Indexation du nouveau fichier :" + fileName.toString(), "Information", JOptionPane.INFORMATION_MESSAGE);		
						System.out.println("Indexation juste du fichier : " + fileName.toString());
					}
					else {
						if(kind == ENTRY_DELETE) {
							//Boîte du message d'information
							JOptionPane.showMessageDialog(null, "Suppression du descripteur de :" + fileName.toString(), "Information", JOptionPane.INFORMATION_MESSAGE);		
							System.out.println("Reindexation de toute la base");
						}
						if(kind == ENTRY_MODIFY) {
							//Boîte du message d'information
							JOptionPane.showMessageDialog(null, "Ré-indexation du fichier modifié :" + fileName.toString(), "Information", JOptionPane.INFORMATION_MESSAGE);		
							System.out.println("Reindexation de toute la base");
						}
					}

				}

				// Reset the key -- this step is critical if you want to
				// receive further watch events.  If the key is no longer valid,
				// the directory is inaccessible so exit the loop.
				boolean valid = key.reset();
				if (!valid) {
					break;
				}
			}
			//}

			catch (IOException e) {
				e.printStackTrace();
			}

		}while(actif);
	}

}
