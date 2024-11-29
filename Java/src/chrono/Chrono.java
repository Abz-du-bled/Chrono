/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chrono;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
public class Chrono {

      
    private static Timer timer;
    private static boolean active = true;
    private static int temps = 0;
    private static int Hours = 0;
    private static int minutes = 0;
    private static int seconds = 0;

    
    public static void main(String[] args) {
        JFrame affiche = new JFrame("Réveil");
        affiche.setBounds(480,210,640,500);  
        affiche.setVisible(true);
        affiche.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        affiche.setLayout(null); 
        affiche.setBackground(Color.LIGHT_GRAY);
        
        JLabel texte = new JLabel("Chronomètre OffLine.");
        affiche.add(texte);
        texte.setBounds(220,20,300,20);
        texte.setFont(new Font("Serif", Font.ITALIC, 20));
        
        JLabel hours = new JLabel("0");
        affiche.add(hours);
        hours.setFont(new Font("Serif", Font.ITALIC, 20));
        hours.setBounds(145,153,40,35);
        
        JLabel minute = new JLabel("0");
        affiche.add(minute);
        minute.setFont(new Font("Serif", Font.ITALIC, 20));
        minute.setBounds(255,155,40,35);
        
        JLabel seconde = new JLabel("0");
        affiche.add(seconde);
        seconde.setFont(new Font("Serif", Font.ITALIC, 20));
        seconde.setBounds(370,155,40,35);
        
        
        JLabel Heure = new JLabel("heure(s)");
        affiche.add(Heure);
        Heure.setBounds(172,160,150,20);
        Heure.setFont(new Font("Serif", Font.ITALIC, 20));
        
        JLabel Minute = new JLabel("minute(s)");
        affiche.add(Minute);
        Minute.setBounds(277,160,150,20);
        Minute.setFont(new Font("Serif", Font.ITALIC, 20));
        
        JLabel Seconde = new JLabel("seconde(s)");
        affiche.add(Seconde);
        Seconde.setBounds(400,160,150,20);
        Seconde.setFont(new Font("Serif", Font.ITALIC, 20));
        
        JLabel mode = new JLabel("Mode : ");
        affiche.add(mode);
        mode.setBounds(250,400,160,20);
        mode.setFont(new Font("Serif", Font.ITALIC, 20));
        
        JButton action = new JButton("Go");
        affiche.add(action);
        action.setBounds(175, 250, 60, 50);

        JButton pause = new JButton("Pause");
        affiche.add(pause);
        pause.setBounds(265, 250, 75, 50);
        pause.setEnabled(false);
        
        JButton reset = new JButton("Reset");
        affiche.add(reset);
        reset.setBounds(365, 250, 75, 50);
        
        

        action.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {           
                mode.setText("Mode : Go");
                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {                        
                        Décompte();    
                        hours.setText(String.valueOf(Hours));
                        minute.setText(String.valueOf(minutes));
                        seconde.setText(String.valueOf(seconds));
                        }
                    });
                    timer.start();
                    boolean active = true;
                    action.setEnabled(false);
                    pause.setEnabled(true);
                    reset.setEnabled(true);
              }
            //J'avais proposé une combinaison de boucle mais le problème qu'en associant le Timer, le programme se bloque et ne se lance pas.
            //Donc il faut placer des conditions lorsqu'on utilise des timers.
        });  
        
        pause.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {                
               if(active == true )
               {
                   mode.setText("Mode : Pause-ON");
                   timer.stop();
                   active = false;  
               }
               else if(active == false)
               {
                   mode.setText("Mode : Pause-OFF"); 
                   active = true;
                    float minu = temps/60;
                    float heure = temps / 3600;
                    if(temps<60)
                    {
                        hours.setText("0");
                        minute.setText("0");
                        seconde.setText(""+temps);
                    }
                    else if(temps>60)
                    {
                        Hours = temps / minutes;
                        minutes = temps / seconds;
                        seconds = temps % 60;
                        hours.setText(""+Hours);
                        minute.setText(""+minutes);
                        seconde.setText(""+seconds);
                    }
                   timer.start();
                   Décompte();
                }
            }               
        });
        
        
        reset.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {  
                mode.setText("Mode : Reset");
                if (timer != null) {
                    timer.stop();
                }
                hours.setText("0");
                minute.setText("0");
                seconde.setText("0");
                active = false;
                action.setEnabled(true);
                pause.setEnabled(false);
                temps = 0;
                Hours = 0;
                minutes = 0;
                seconds = 0;
         }               
        });      
    }
    
    public static void Décompte(){        
        seconds++;
        temps++;
        if (seconds == 60) 
        {
            seconds = 0;
            minutes++;
            if (minutes == 60) 
            {
                minutes = 0;
                Hours++;
            }
        }
    }
    
}
