package chatandlaunch;
// monotask

public class ChatAndLaunch {
    public static void main(String[] args) {
        Parrot0 parrot = new Parrot0 ("coco",4);
        blabla(); blabla();
        parrot.run ();
        for (int n=0; n<3; n++) {
            try {Thread.sleep(1000);}
            catch (InterruptedException e) {
                System.out.println (e.getMessage ());
                System.exit(1); }
            blabla ();
        }
    }
    private static void blabla() {
        System.out.println("blabla");
    }
}
class Parrot0 {
    private String cri = null;
    private int fois = 0;
    public Parrot0 (String s, int i) {
        cri = s;
        fois = i;
    }

    public void run() {
        for (int n=0; n<fois; n++) {
            try {Thread.sleep (1000);} catch (InterruptedException e) {
                System.out.println(e.getMessage()); System.exit(1);
            }
            System.out.println (cri);
        } // end for
    }//end run
}