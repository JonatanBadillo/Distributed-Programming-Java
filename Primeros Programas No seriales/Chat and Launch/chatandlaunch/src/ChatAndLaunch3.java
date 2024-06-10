package chatandlaunch3;

public class ChatAndLaunch3 {
    public static void main(String[] args) {
        Parrot1 objectParrot = new Parrot1 ("coco",10);
        Thread ThreadParrot = new Thread (objectParrot);
        ThreadParrot.start();
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

class Parrot1 implements Runnable {
    private String cri = null;
    private int fois = 0;
    public Parrot1 (String s, int i) {
        cri = s;
        fois = i;
    }
    public void run (){
        for (int n=0; n<fois; n++) {
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e) { }
            System.out.println (cri);
        }
    }
}