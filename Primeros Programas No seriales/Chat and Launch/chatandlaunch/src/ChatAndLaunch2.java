package chatandlaunch2;

public class ChatAndLaunch2 {
    public static void main(String[] args) {
        Parrot2 parrot = new Parrot2 ("coco",10);
        parrot.start();
        for (int n=0; n<10; n++) {
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e) { }
            blabla();
        }
    }
    private static void blabla() {
        System.out.println("blabla");
    }
}

class Parrot2 extends Thread{
    private String cri = null;
    private int fois = 0;
    public Parrot2 (String s, int i) {
        cri = s;
        fois = i;
    }
    public void run ( ){
        for (int n=0; n<fois; n++) {
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e) { }
            System.out.println (cri);
        }
    }
}