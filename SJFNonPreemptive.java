package sjf.nonpreemptive;

/**
 *
 * @author Awanda
 */

import javax.swing.*;

public class SJFNonPreemptive {

    public static void main(String[] args) {
        String proses,tmp,tmpname;
        String[] at = new String[100],bt = new String[100], namap = new String[100];
        int[] wtp = new int[100],time = new int[100];
        int i,j,btime=0,min,f=0;
        double awt,totwtp = 0;
        proses = JOptionPane.showInputDialog("Masukkan Berapa Proses");
        for(i=1;i<=Integer.parseInt(proses);i++){
            namap[i] = JOptionPane.showInputDialog("Nama Proses");
            at[i] = JOptionPane.showInputDialog("Arrival Time Proses "+namap[i]);
            bt[i] = JOptionPane.showInputDialog("Burst Time Proses "+namap[i]);
        }
        for(i=1;i<=Integer.parseInt(proses);i++){
            for(j=1+i;j<=Integer.parseInt(proses);j++){
                if(Integer.parseInt(at[i])>Integer.parseInt(at[j])){
                    tmpname = namap[i];
                    namap[i] = namap[j];
                    namap[j] = tmpname;
                    
                    tmp = at[i];
                    at[i] = at[j];
                    at[j] = tmp;
                    
                    tmp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = tmp;
                }
            }
        } 
        bt[0] = "0";
        for(i=1;i<=Integer.parseInt(proses);i++){
            btime = btime+Integer.parseInt(bt[f]);
            min = Integer.parseInt(bt[i]);
            for(j=1+i;j<=Integer.parseInt(proses);j++){
                if(btime>=Integer.parseInt(at[j])&&Integer.parseInt(bt[j])<min){
                    
                        tmpname = namap[i];
                        namap[i] = namap[j];
                        namap[j] = tmpname;
                        
                        tmp = at[i];
                        at[i] = at[j];
                        at[j] = tmp;
                        
                        tmp = bt[i];
                        bt[i] = bt[j];
                        bt[j] = tmp;
                }
            }
            f++;
        } 
        time[1] = Integer.parseInt(at[1]);
        System.out.println("Tabel Proses");
        System.out.println("=========================================================");
        System.out.println("| No | Nama Proses\t | Arrival Time\t | Burst Time \t|");
        for(i=1;i<=Integer.parseInt(proses);i++){
            System.out.println("| "+i+"  | "+namap[i]+"\t\t | "+at[i]+" \t\t | "+bt[i]+"\t\t|");
            time[i+1] = time[i]+Integer.parseInt(bt[i]);
        }
        System.out.println("=========================================================");
        wtp[1] = Integer.parseInt(at[1])-0;
        System.out.println("\n\nWaiting Time");
        System.out.println("=========================================================");
        System.out.println("Waiting Time "+namap[1]+" = "+wtp[1]);
        for(i=2;i<=Integer.parseInt(proses);i++){
            wtp[i] = time[i]-Integer.parseInt(at[i]);
            System.out.println("Waiting Time "+namap[i]+" = "+wtp[i]);
        }
        System.out.println("=========================================================");
        for(i=1;i<=Integer.parseInt(proses);i++){
            totwtp += wtp[i];
        }
        System.out.println("\n\nDiagram Gantt Chart");
        System.out.println("=========================================================");
        for(i=1;i<=Integer.parseInt(proses);i++){
            System.out.print(namap[i]+"\t ");
            if(i>=3){
                for(j=1;j<=Integer.parseInt(proses)-2;j++){
                    String Spasi = " ";
                    System.out.print(Spasi);
                    Spasi += " ";
                }
            }
        }
        System.out.print("\n");
        for(i=1;i<=Integer.parseInt(proses);i++){
            System.out.print("|========");
        }
        System.out.print("\n");
        for(i=1;i<=Integer.parseInt(proses)+1;i++){
            System.out.print(time[i]+"\t ");
            if(i>2){
                for(j=1;j<=Integer.parseInt(proses)-2;j++){
                    String Spasi = " ";
                    System.out.print(Spasi);
                    Spasi += " ";
                }
            }
        }
        System.out.print("\n");
        System.out.println("=========================================================");
        System.out.println("\n\nAverage Waiting Time");
        System.out.println("=========================================================");
        awt = totwtp/Float.parseFloat(proses);
        System.out.println("Total Average Waiting Time = "+awt);
        System.out.println("=========================================================");
    }
}
