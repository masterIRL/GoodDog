package vuegraphique;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.ControlModeGestion;
import control.ControlVerifierIdentification;

public class FrameReglage extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel panContents = new JPanel();
	private JPanel panReglage = new JPanel();
	private JPanel panTop = new JPanel();
	private JPanel panCenter = new JPanel();
	private PanConfig panConfig;
	private PanIndexer panIndexation;
	
	private CardLayout cartes = new CardLayout();
	
	Box boxMiseEnPageReglage = Box.createVerticalBox();
	//Box boxTop = Box.createVerticalBox();
	JButton boutonConfig = new JButton();
	JButton boutonIndexation = new JButton();
	JButton boutonMode = new JButton();
	JLabel labelOnOff= new JLabel();
	JLabel labelconfigIndex= new JLabel();
	JLabel labelLancerIndex= new JLabel();
	ControlModeGestion controlModeGestion;

	public FrameReglage(ControlVerifierIdentification controlVerifier, ControlModeGestion controlModeGestion) {
		
		this.setTitle("Réglage");  //Définit un titre
		this.setBackground(Color.WHITE);
		this.setSize(800, 650); //Définit sa taille 
		this.setLocationRelativeTo(null); //Positionne au centre la fenetre
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        this.controlModeGestion=controlModeGestion;
        
        this.panIndexation = new PanIndexer(this, controlVerifier);
        this.panConfig = new PanConfig(this);

        this.panContents.setLayout(cartes); //ajoute à panContents le Layout de cartes
		this.panContents.add(this.panIndexation,"INDEXER");
		this.panContents.add(this.panConfig,"CONFIG");
	
		this.initialisation(); //initialisation de la page de reglage
		this.getContentPane().add(panContents);
		this.setVisible(true);
		
		

		
		

		/*this.panTop.add(labelConnect,BorderLayout.WEST); // ajout de l'image au panel haut
		this.add(panTop,BorderLayout.NORTH); //ajout du panel haut au panel utilisateur 

		initBoxMiseEnPageMotCle();

		this.panCenter.add(boxMiseEnPageMotCle);
		boxMiseEnPageMotCle.setVisible(true);
		this.add(panCenter,BorderLayout.CENTER); */

	}
	
	
	private void initialisation() {
		this.panTop.setBackground(new Color(104,92,82));
		this.panCenter.setBackground(Color.WHITE);
		this.panReglage.setLayout(new BorderLayout());
		this.panTop.setLayout(new BorderLayout()); //Configuration du panel haut de la frame
		/*boutonRetour.setPreferredSize(new Dimension(80,80));
		boutonRetour.setMaximumSize(new Dimension(80,80));
		boutonRetour.setMinimumSize(new Dimension(80,80));*/
		
		JLabel texteResultat=new JLabel("RÉGLAGES DE GOODOG"); //TROUVER UNE SOLUTION POUR AFFICHER LE TEXTE AU CENTRE
		texteResultat.setFont(new Font("Poppins-Black", Font.BOLD,30));
		texteResultat.setForeground(Color.WHITE);
		texteResultat.setHorizontalAlignment((int)CENTER_ALIGNMENT);
		panTop.add(Box.createRigidArea(new Dimension(0,80)),BorderLayout.WEST);
		//panTop.add(Box.createRigidArea(new Dimension(80,80)),BorderLayout.EAST);
		panTop.add(texteResultat,BorderLayout.CENTER);
		
		
		
		BufferedImage configIndex=null;
		try {
			configIndex = ImageIO.read(new File("RESSOURCE/IMAGE/ConfigIndex.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon configIndexIcon=new ImageIcon(configIndex);
		BufferedImage configIndexClick=null;
		try {
			configIndexClick = ImageIO.read(new File("RESSOURCE/IMAGE/ConfigIndexClick.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon configIndexIconClick=new ImageIcon(configIndexClick);
		labelconfigIndex.setIcon(configIndexIcon);
		labelconfigIndex.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//à ajouter et mettre pour chaque label
		labelconfigIndex.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				panConfig.initialisation(); //initialisation de la page de configuration
				showConfig();
			}
            @Override
            public void mouseEntered(MouseEvent e) {
            	labelconfigIndex.setIcon(configIndexIconClick);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	labelconfigIndex.setIcon(configIndexIcon);
            }
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		
		
		BufferedImage lancerIndex=null;
		try {
			lancerIndex = ImageIO.read(new File("RESSOURCE/IMAGE/LancerIndex.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon lancerIndexIcon=new ImageIcon(lancerIndex);
		BufferedImage lancerIndexClick=null;
		try {
			lancerIndexClick = ImageIO.read(new File("RESSOURCE/IMAGE/LancerIndexClick.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon lancerIndexIconClick=new ImageIcon(lancerIndexClick);
		labelLancerIndex.setIcon(lancerIndexIcon);
		labelLancerIndex.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//à ajouter et mettre pour chaque label
		labelLancerIndex.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
		        panIndexation.initialisation(); //initialisation de la page d'indexation
				showIndexer();
			}
            @Override
            public void mouseEntered(MouseEvent e) {
            	labelLancerIndex.setIcon(lancerIndexIconClick);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	labelLancerIndex.setIcon(lancerIndexIcon);
            }
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		
		BufferedImage On=null;
		try {
			On = ImageIO.read(new File("RESSOURCE/IMAGE/On.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon OnIcon=new ImageIcon(On);
		
		BufferedImage Off=null;
		try {
			Off = ImageIO.read(new File("RESSOURCE/IMAGE/Off.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		ImageIcon OffIcon=new ImageIcon(Off);
		BufferedImage OnClick=null;
		try {
			OnClick = ImageIO.read(new File("RESSOURCE/IMAGE/OnClick.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon OnIconClick=new ImageIcon(OnClick);
		
		BufferedImage OffClick=null;
		try {
			OffClick = ImageIO.read(new File("RESSOURCE/IMAGE/OffClick.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		ImageIcon OffIconClick=new ImageIcon(OffClick);
		
		if (controlModeGestion.isOuvert()) {
			labelOnOff.setIcon(OnIcon);
		} else {
			labelOnOff.setIcon(OffIcon);
		}
		System.out.println(controlModeGestion.isOuvert()); //Test
		
		//Bouton + interaction
		labelOnOff.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//à ajouter et mettre pour chaque label
		labelOnOff.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if (controlModeGestion.isOuvert()) {
					controlModeGestion.desactiverModeOuvert(); 
					labelOnOff.setIcon(OffIconClick);
					System.out.println("1"); //Test
					System.out.println(controlModeGestion.isOuvert()); //Test
				} else {
					controlModeGestion.activerModeOuvert(); //ERREUR A CORRIGER "Exception in thread "AWT-EventQueue-0" java.lang.IllegalThreadStateException"
					labelOnOff.setIcon(OnIconClick);
					System.out.println("2"); //Test
					System.out.println(controlModeGestion.isOuvert()); //Test
				}
			}
            @Override
            public void mouseEntered(MouseEvent e) {
				if (controlModeGestion.isOuvert()) {
					labelOnOff.setIcon(OnIconClick);
				} else {
					labelOnOff.setIcon(OffIconClick);
				}

            }

            @Override
            public void mouseExited(MouseEvent e) {
				if (controlModeGestion.isOuvert()) {
					labelOnOff.setIcon(OnIcon);
				} else {
					labelOnOff.setIcon(OffIcon);
				}
            }
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		
		
		boxMiseEnPageReglage.add(Box.createRigidArea(new Dimension(0,70)));
		boxMiseEnPageReglage.add(labelconfigIndex);
		boxMiseEnPageReglage.add(Box.createRigidArea(new Dimension(0,25)));
		boxMiseEnPageReglage.add(labelLancerIndex);
		boxMiseEnPageReglage.add(Box.createRigidArea(new Dimension(0,35)));
		boxMiseEnPageReglage.add(labelOnOff);
		boxMiseEnPageReglage.add(Box.createRigidArea(new Dimension(0,25)));

		
		
		
		
		boxMiseEnPageReglage.setVisible(true);
		this.panCenter.add(boxMiseEnPageReglage);
		this.panReglage.add(panTop,BorderLayout.NORTH);
		this.panReglage.add(panCenter,BorderLayout.CENTER);
		this.panCenter.setVisible(true);
		this.panContents.add(panReglage,"REGLAGE");
		this.cartes.show(panContents, "REGLAGE");
	}
	
	
	public void showReglage() {
		this.cartes.show(panContents, "REGLAGE");
		repaint();
	}
	
	public void showIndexer() {
		this.cartes.show(panContents, "INDEXER");
		repaint();
	}
	
	public void showConfig() {
		this.cartes.show(panContents, "CONFIG");
		repaint();
	}
	
}
