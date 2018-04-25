package vuegraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import control.ControlIndexation;
import control.ControlVerifierIdentification;
import model.TypeFichier;

class PanIndexer extends JPanel {

	private static final long serialVersionUID = 1L;
	private FrameReglage frame;
	private ControlIndexation controlIndexation;

	private JPanel panTop=new JPanel();
	private JPanel panCenter = new JPanel();
	Color couleur=(new Color(104,92,82));
	Color couleur2=(new Color(177,143,117));


	private JButton buttonRetour=new JButton();

	private JLabel boutonIndexTexte = new JLabel();
	private JLabel boutonIndexImage= new JLabel();
	private JLabel boutonIndexSon= new JLabel();
	
	private Box boxMiseEnPageIndexation=Box.createVerticalBox();
	private Box boxChoixIndexImage=Box.createHorizontalBox();
	private Box boxChoixIndexTexte=Box.createHorizontalBox();
	private Box boxChoixIndexSon=Box.createHorizontalBox();



	private Timer timerImage;
	private Timer timerTexte;
	private Timer timerSon;	
	
	
	public PanIndexer(FrameReglage frame, ControlVerifierIdentification controlVerifier) {
		super();
		this.controlIndexation = new ControlIndexation(controlVerifier);
		this.frame = frame;
	}

	public void initialisation(){
		JCheckBox checkboxImage=new JCheckBox();
		JCheckBox checkboxTexte=new JCheckBox();
		JCheckBox checkboxSon=new JCheckBox();

		JProgressBar progressbarImage=new JProgressBar();
		progressbarImage.setForeground(couleur2);
		progressbarImage.setBorderPainted(false);
		JProgressBar progressbarTexte=new JProgressBar();
		progressbarTexte.setForeground(couleur2);
		progressbarTexte.setBorderPainted(false);
		JProgressBar progressbarSon=new JProgressBar();
		progressbarSon.setForeground(couleur2);
		progressbarSon.setBorderPainted(false);
		this.setLayout(new BorderLayout());

		//////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////
		///////////////                                   ////////////////////
		///////////////              PANEL TOP            ////////////////////
		///////////////                                   ////////////////////
		//////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////
		panTop.setBackground(couleur);
		panTop.setLayout(new BorderLayout());

		//////////////////////////////////////////////////////////////////////
		////////////                bouton Retour          ///////////////////
		//////////////////////////////////////////////////////////////////////
		
		buttonRetour.setBackground(couleur);
		buttonRetour.setForeground(Color.WHITE); //new Color(59, 89, 182)
		buttonRetour.setFocusPainted(false);
		buttonRetour.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonRetour.setText("Retour");
		buttonRetour.setBorderPainted(false);
		buttonRetour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonRetour.setPreferredSize(new Dimension(80,80));
		buttonRetour.setMaximumSize(new Dimension(80,80));
		buttonRetour.setMinimumSize(new Dimension(80,80));
		buttonRetour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		////////////        listener du bouton retour           //////////////
		buttonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boxMiseEnPageIndexation.removeAll();
				boxChoixIndexTexte.removeAll();
				boxChoixIndexImage.removeAll();
				boxChoixIndexSon.removeAll();
				removeAll();
				frame.showReglage();
			}
		});
		panTop.add(buttonRetour,BorderLayout.WEST);
		
		//////////////////////////////////////////////////////////////////////
		////////////                Texte titre            ///////////////////
		//////////////////////////////////////////////////////////////////////
		JLabel texteResultat=new JLabel("INDEXATION          ");
		texteResultat.setFont(new Font("Poppins-Black", Font.BOLD,30));
		texteResultat.setForeground(Color.WHITE);
		texteResultat.setHorizontalAlignment((int)CENTER_ALIGNMENT);
		panTop.add(texteResultat,BorderLayout.CENTER);

		//////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////
		///////////////                                   ////////////////////
		///////////////            PANEL Centre           ////////////////////
		///////////////                                   ////////////////////
		//////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////
		panCenter.setBackground(Color.WHITE);
		boxMiseEnPageIndexation.add(Box.createRigidArea(new Dimension(-30,60)));


		//////////////////////////////////////////////////////////////////////
		////////////          bouton indexation Image          ///////////////
		//////////////////////////////////////////////////////////////////////

		
		checkboxImage.setVisible(false);
		checkboxImage.setBackground(Color.WHITE);
		checkboxImage.setEnabled(false);
		checkboxImage.setBorderPainted(false);
		progressbarImage.setVisible(false);
		progressbarImage.setStringPainted(true);
		
		ActionListener updateProBarImage = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				int val = progressbarImage.getValue();
				if (val >= 100) {
					timerImage.stop();
					progressbarImage.setVisible(false);
					checkboxImage.setVisible(true);
					checkboxImage.setSelected(true);
					return;
				}
				progressbarImage.setValue(++val);
			}
		};
		timerImage = new Timer(20, updateProBarImage);
		
		BufferedImage configIndex=null;
		try {
			configIndex = ImageIO.read(new File("RESSOURCE/IMAGE/ConfigImage.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon configIndexIcon=new ImageIcon(configIndex);
		BufferedImage configIndexClick=null;
		try {
			configIndexClick = ImageIO.read(new File("RESSOURCE/IMAGE/ConfigIndexImage.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon configIndexIconClick=new ImageIcon(configIndexClick);
		boutonIndexImage.setIcon(configIndexIcon);
		boutonIndexImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//à ajouter et mettre pour chaque label
		boutonIndexImage.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(progressbarImage.getValue()<100 && progressbarImage.getValue() >=0) {
					indexer(TypeFichier.IMAGE); //indexation du Texte
					progressbarImage.setVisible(true);
					timerImage.start();   
				}
			}
            @Override
            public void mouseEntered(MouseEvent e) {
            	boutonIndexImage.setIcon(configIndexIconClick);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	boutonIndexImage.setIcon(configIndexIcon);
            }
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		boxChoixIndexImage.add(boutonIndexImage);
		boxChoixIndexImage.add(checkboxImage);
		boxChoixIndexImage.add(progressbarImage);	
		boxMiseEnPageIndexation.add(boxChoixIndexImage);
		boxMiseEnPageIndexation.add(Box.createRigidArea(new Dimension(0,30)));
		
		

		
		//////////////////////////////////////////////////////////////////////
		////////////          bouton indexation Texte          ///////////////
		//////////////////////////////////////////////////////////////////////
		
		
		checkboxTexte.setVisible(false);
		checkboxTexte.setBackground(Color.WHITE);
		checkboxTexte.setEnabled(false);
		checkboxTexte.setBorderPainted(false);
		progressbarTexte.setVisible(false);
		progressbarTexte.setStringPainted(true);
		
		ActionListener updateProBarTexte = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				int val = progressbarTexte.getValue();
				if (val >= 100) {
					timerTexte.stop();
					progressbarTexte.setVisible(false);
					checkboxTexte.setVisible(true);
					checkboxTexte.setSelected(true);
					return;
				}
				progressbarTexte.setValue(++val);
			}
		};
		timerTexte = new Timer(20, updateProBarTexte);
		
		BufferedImage configIndex1=null;
		try {
			configIndex1 = ImageIO.read(new File("RESSOURCE/IMAGE/ConfigTexte.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon configIndex1Icon=new ImageIcon(configIndex1);
		BufferedImage configIndex1Click=null;
		try {
			configIndex1Click = ImageIO.read(new File("RESSOURCE/IMAGE/ConfigIndexTexte.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon configIndex1IconClick=new ImageIcon(configIndex1Click);
		boutonIndexTexte.setIcon(configIndex1Icon);
		boutonIndexTexte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//à ajouter et mettre pour chaque label
		boutonIndexTexte.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(progressbarTexte.getValue()<100 && progressbarTexte.getValue() >=0) {
					indexer(TypeFichier.TEXTE); //indexation du Texte
					progressbarTexte.setVisible(true);
					timerTexte.start();   
				}
			}
            @Override
            public void mouseEntered(MouseEvent e) {
            	boutonIndexTexte.setIcon(configIndex1IconClick);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	boutonIndexTexte.setIcon(configIndex1Icon);
            }
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		boxChoixIndexTexte.add(boutonIndexTexte);
		boxChoixIndexTexte.add(checkboxTexte);
		boxChoixIndexTexte.add(progressbarTexte);	
		boxMiseEnPageIndexation.add(boxChoixIndexTexte);
		boxMiseEnPageIndexation.add(Box.createRigidArea(new Dimension(0,30)));
		
		
		
		
		
		
		//////////////////////////////////////////////////////////////////////
		////////////          bouton indexation Son          /////////////////
		//////////////////////////////////////////////////////////////////////
		checkboxSon.setVisible(false);
		checkboxSon.setBackground(Color.WHITE);
		checkboxSon.setEnabled(false);
		checkboxSon.setBorderPainted(false);
		progressbarSon.setVisible(false);
		progressbarSon.setStringPainted(true);
		
		ActionListener updateProBarSon = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				int val = progressbarSon.getValue();
				if (val >= 100) {
					timerSon.stop();
					progressbarSon.setVisible(false);
					checkboxSon.setVisible(true);
					checkboxSon.setSelected(true);
					return;
				}
				progressbarSon.setValue(++val);
			}
		};
		timerSon = new Timer(20, updateProBarSon);
		
		BufferedImage configIndex2=null;
		try {
			configIndex2 = ImageIO.read(new File("RESSOURCE/IMAGE/ConfigSon.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon configIndex2Icon=new ImageIcon(configIndex2);
		BufferedImage configIndex2Click=null;
		try {
			configIndex2Click = ImageIO.read(new File("RESSOURCE/IMAGE/ConfigIndexSon.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon configIndex2IconClick=new ImageIcon(configIndex2Click);
		boutonIndexSon.setIcon(configIndex2Icon);
		boutonIndexSon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//à ajouter et mettre pour chaque label
		boutonIndexSon.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(progressbarSon.getValue()<100 && progressbarSon.getValue() >=0) {
					indexer(TypeFichier.SON); //indexation du Son
					progressbarSon.setVisible(true);
					timerSon.start();   
				}
			}
            @Override
            public void mouseEntered(MouseEvent e) {
            	boutonIndexSon.setIcon(configIndex2IconClick);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	boutonIndexSon.setIcon(configIndex2Icon);
            }
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		boxChoixIndexSon.add(boutonIndexSon);
		boxChoixIndexSon.add(checkboxSon);
		boxChoixIndexSon.add(progressbarSon);	
		boxMiseEnPageIndexation.add(boxChoixIndexSon);
		boxMiseEnPageIndexation.add(Box.createRigidArea(new Dimension(0,30)));
		

		////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////





		panCenter.add(boxMiseEnPageIndexation);

		this.add(panTop,BorderLayout.NORTH);
		this.add(panCenter,BorderLayout.CENTER);
	}
	
	private void indexer(TypeFichier typeFichier) {
		controlIndexation.indexer(typeFichier);
	}

}
