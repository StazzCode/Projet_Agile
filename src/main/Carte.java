public class Carte{

    public static Case[][] carte = new Case[10][20];

    public static void initCarte(){
        for(int i = 0;i < carte.length;i ++){
            for(int j = 0; j < carte[i].length;j++){
                if(j == 0||j == 19){
                    carte[i][j] = new Meuble(false, "X");
                }else if(i == 0 || i == 9){
                    carte[i][j] = new Meuble(false, "Y");
                }else{
                    carte[i][j] = new Meuble(true, " ");
                }
            }
        }
    }

    public static void displayCarte(){
        for(int i = 0;i < carte.length;i ++){
            for(int j = 0; j < carte[i].length;j++){
                System.out.print(carte[i][j].getName());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        initCarte();
        displayCarte();
    }

}