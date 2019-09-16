public class MatchArrays{

    static int calcMinimumMoves(int [] andrea, int [] maria){
        int moves = 0;
        for(int counter = 0; counter < andrea.length; counter ++){
            //this calculate magnitude of number
            String andreaNumber = String.valueOf(andrea[counter]);
            //10 raised to x
            int magnitude = (int)Math.pow((double)10, (double)(andreaNumber.length() - 1));
            moves += moves(andrea[counter], maria[counter], magnitude,0);
        }
        return moves;
    }

    static int moves(int andrea, int maria, int magnitude, int moves){

        if(magnitude > 0){
            //extract first major digit of two array
            int andreaDigit = andrea/magnitude;
            int mariaDigit = maria/magnitude;
            //store diference between two digits
            moves += Math.abs((andreaDigit) - (mariaDigit));
            //substract magnitud of numbers
            andrea -= andreaDigit * magnitude;
            maria -= mariaDigit * magnitude;
            //repeat all
            return moves(andrea, maria, magnitude/10, moves);

        }
        return  moves;
    }

    public static void main(String[] args) {
        int [] andrea = {123,543};
        int [] maria = {321,279};
        int moves = calcMinimumMoves(andrea, maria);

        System.out.println("Moves: " + moves);
    }
}