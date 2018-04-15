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
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.border.Border;

 class PanIndexer extends JPanel {

	
	private JPanel panTop=new JPanel();
	private JPanel panCenter = new JPanel();
	private JButton buttonIndexImage=new JButton();
	private JButton buttonIndexTexte=new JButton();
	private JButton buttonIndexSon=new JButton();
	private JButton buttonRetour=new JButton();
	private Box boxMiseEnPageIndexation=Box.createVerticalBox();
	private Box boxChoixIndexImage=Box.createHorizontalBox();
	private Box boxChoixIndexTexte=Box.createHorizontalBox();
	private Box boxChoixIndexSon=Box.createHorizontalBox();
	private JCheckBox checkboxImage=new JCheckBox();
	private JCheckBox checkboxTexte=new JCheckBox();
	private JCheckBox checkboxSon=new JCheckBox();
	private JProgressBar progressbarImage=new JProgressBar();
	private JProgressBar progressbarTexte=new JProgressBar();
	private JProgressBar progressbarSon=new JProgressBar();
	private Timer timerImage;
	private Timer timerTexte;
	private Timer timerSon;
	FrameAdmin frame;
	
	

	
    public void initialisation(){
    	
    	this.setLayout(new BorderLayout());
    	
    	//////////////////////////////////////////////////////////////////////
    	//////////////////////////////////////////////////////////////////////
    	///////////////                                   ////////////////////
    	///////////////              PANEL TOP            ////////////////////
    	///////////////                                   ////////////////////
    	//////////////////////////////////////////////////////////////////////
    	//////////////////////////////////////////////////////////////////////
    	panTop.setBackground(Color.WHITE);
    	panTop.setLayout(new BorderLayout());
    	
        //////////////////////////////////////////////////////////////////////
        ////////////                bouton Retour          ///////////////////
        //////////////////////////////////////////////////////////////////////
    	buttonRetour.setBackground(Color.WHITE);
    	buttonRetour.setForeground(new Color(59, 89, 182));
    	buttonRetour.setFocusPainted(false);
    	buttonRetour.setFont(new Font("Tahoma", Font.BOLD, 12));
    	buttonRetour.setText("Retour");
    	buttonRetour.setBorderPainted(false);
    	buttonRetour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	
    	////////////        listener du bouton retour           //////////////
    	buttonRetour.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			
	    				frame.cartes.show(frame.panAccueil, "ECRAN_ACCUEIL");
	    		
	    		}
	    	});
    	
    	
    	panTop.add(buttonRetour,BorderLayout.WEST);
    	
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
    	
    	buttonIndexImage.setBackground(Color.WHITE);
    	buttonIndexImage.setForeground(new Color(59, 89, 182));
    	buttonIndexImage.setFocusPainted(false);
    	buttonIndexImage.setFont(new Font("Tahoma", Font.BOLD, 12));
    	buttonIndexImage.setText("Indexation Image");
    	buttonIndexImage.setBorderPainted(false);
    	
    	buttonIndexImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	
    	checkboxImage.setVisible(false);
    	checkboxImage.setBackground(Color.WHITE);
    	checkboxImage.setEnabled(false);
    	checkboxImage.setBorderPainted(false);
    	progressbarImage.setVisible(false);
    	progressbarImage.setStringPainted(true);
    	progressbarImage.setBounds(0, 0, 40, 20);
    	
    	
        ////////////        listener du bouton index Image           /////////////
    	///////////             click sur le bouton                  /////////////
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
          buttonIndexImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(progressbarImage.getValue()<100 && progressbarImage.getValue() >=0) {
            	progressbarImage.setVisible(true);
            	timerImage.start();   
            	}
            }
            
          });
          
         ////////////        listener du bouton index Image           /////////////
      	 ///////////         passage de la souris sur le bouton       /////////////  
    	buttonIndexImage.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonIndexImage.setForeground(new Color(59, 89, 182));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonIndexImage.setForeground(Color.GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub	
			}
		});
    	

  
    	boxChoixIndexImage.add(buttonIndexImage);
    	boxChoixIndexImage.add(checkboxImage);
    	boxChoixIndexImage.add(progressbarImage);	
    	boxMiseEnPageIndexation.add(boxChoixIndexImage);
    	boxMiseEnPageIndexation.add(Box.createRigidArea(new Dimension(0,30)));
    	
        //////////////////////////////////////////////////////////////////////
        ////////////          bouton indexation Texte          ///////////////
        //////////////////////////////////////////////////////////////////////
    	buttonIndexTexte.setBackground(Color.WHITE);
    	buttonIndexTexte.setForeground(new Color(59, 89, 182));
    	buttonIndexTexte.setFocusPainted(false);
    	buttonIndexTexte.setFont(new Font("Tahoma", Font.BOLD, 12));
    	buttonIndexTexte.setText("Indexation Texte");
    	buttonIndexTexte.setBorderPainted(false);
    	
    	buttonIndexTexte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	
    	checkboxTexte.setVisible(false);
    	checkboxTexte.setBackground(Color.WHITE);
    	checkboxTexte.setEnabled(false);
    	checkboxTexte.setBorderPainted(false);
    	progressbarTexte.setVisible(false);
    	progressbarTexte.setStringPainted(true);
    	
        ////////////        listener du bouton index Texte           //////////////
        ///////////             click sur le bouton                  /////////////
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
          buttonIndexTexte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(progressbarTexte.getValue()<100 && progressbarTexte.getValue() >=0) {
            	progressbarTexte.setVisible(true);
                timerTexte.start();   
            	}
            }
            
          });
          
          ////////////        listener du bouton index Texte           //////////////
       	  ///////////         passage de la souris sur le bouton        ///////////// 
          buttonIndexTexte.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonIndexTexte.setForeground(new Color(59, 89, 182));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonIndexTexte.setForeground(Color.GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub	
			}
		});
    	

  
    	boxChoixIndexTexte.add(buttonIndexTexte);
    	boxChoixIndexTexte.add(checkboxTexte);
    	boxChoixIndexTexte.add(progressbarTexte);	
    	boxMiseEnPageIndexation.add(boxChoixIndexTexte);
    	boxMiseEnPageIndexation.add(Box.createRigidArea(new Dimension(0,30)));
    	
        //////////////////////////////////////////////////////////////////////
        ////////////          bouton indexation Son          /////////////////
        //////////////////////////////////////////////////////////////////////
    	buttonIndexSon.setBackground(Color.WHITE);
    	buttonIndexSon.setForeground(new Color(59, 89, 182));
    	buttonIndexSon.setFocusPainted(false);
    	buttonIndexSon.setFont(new Font("Tahoma", Font.BOLD, 12));
    	buttonIndexSon.setText("Indexation Son");
    	buttonIndexSon.setBorderPainted(false);
    	
    	buttonIndexSon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	
    	checkboxSon.setVisible(false);
    	checkboxSon.setBackground(Color.WHITE);
    	checkboxSon.setEnabled(false);
    	checkboxSon.setBorderPainted(false);
    	progressbarSon.setVisible(false);
    	progressbarSon.setStringPainted(true);
    	
        ////////////          listener du bouton index Son           //////////////
        ///////////             click sur le bouton                  /////////////
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
          buttonIndexSon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(progressbarSon.getValue()<100 && progressbarSon.getValue() >=0) {
            	progressbarSon.setVisible(true);
                timerSon.start();   
            	}
            }
            
          });
          
          ////////////          listener du bouton index Son            /////////////
       	  ///////////         passage de la souris sur le bouton        ///////////// 
          buttonIndexSon.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonIndexSon.setForeground(new Color(59, 89, 182));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonIndexSon.setForeground(Color.GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub	
			}
		});
    	

  
    	boxChoixIndexSon.add(buttonIndexSon);
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
	private static final long serialVersionUID = 1L;







	

}
