
public class layout{
    public int[][] layOut;
    public layout(int roomSize, roomTypes[][] base){
        int baseSize=base[0].length;
        layOut = new int[roomSize* baseSize][roomSize* baseSize];
        for(int ki = 0; ki < roomSize* baseSize; ki += roomSize){
            for(int kj = 0; kj < roomSize* baseSize; kj += roomSize){
                if (base[ki/roomSize][kj/roomSize] != roomTypes.NOTHING){
                    for(int i = ki; i<ki+roomSize; i++){
                        for(int j = kj; j<kj+roomSize; j++){
                            if(j == kj || j+1 == kj+roomSize || i+1 == ki+roomSize || i == ki){
                                layOut[i][j] = 1;
                            }
                        }
                    }
                    if(ki/roomSize-1 >= 0){
                        if(base[ki/roomSize-1][kj/roomSize] != roomTypes.NOTHING){
                            if(roomSize%2 == 1) {
                                layOut[ki][kj + roomSize / 2] = 2;
                                layOut[ki][kj + roomSize / 2 + 1] = 2;
                                layOut[ki][kj + roomSize / 2 -1] = 2;
                            }else{
                                layOut[ki][kj + roomSize / 2] = 2;
                                layOut[ki][kj + roomSize / 2 - 1] = 2;
                            }
                        }
                    }
                    if(ki/roomSize+1 < baseSize){
                        if(base[ki/roomSize+1][kj/roomSize] != roomTypes.NOTHING){
                            if(roomSize%2 == 1){
                                layOut[ki+roomSize-1][kj + roomSize / 2] = 2;
                                layOut[ki+roomSize-1][kj + roomSize / 2 + 1] = 2;
                                layOut[ki+roomSize-1][kj + roomSize / 2 -1] = 2;
                            }else{
                                layOut[ki+roomSize-1][kj + roomSize / 2] = 2;
                                layOut[ki+roomSize-1][kj + roomSize / 2 - 1] = 2;
                            }
                        }
                    }
                    if(kj/roomSize-1 >= 0){
                        if(base[ki/roomSize][kj/roomSize-1] != roomTypes.NOTHING){
                            if(roomSize%2 == 1){
                                layOut[ki + roomSize / 2 + 1][kj] = 2;
                                layOut[ki + roomSize / 2][kj] = 2;
                                layOut[ki + roomSize / 2 - 1][kj] = 2;
                            }else{
                                layOut[ki + roomSize / 2][kj] = 2;
                                layOut[ki + roomSize / 2 - 1][kj] = 2;
                            }
                        }
                    }
                    if(kj/roomSize+1 < baseSize){
                        if(base[ki/roomSize][kj/roomSize+1] != roomTypes.NOTHING){
                            if(roomSize%2 == 1){
                                layOut[ki + roomSize / 2 + 1][kj+roomSize-1] = 2;
                                layOut[ki + roomSize / 2][kj+roomSize-1] = 2;
                                layOut[ki + roomSize / 2 - 1][kj+roomSize-1] = 2;
                            }else{
                                layOut[ki + roomSize / 2][kj+roomSize-1] = 2;
                                layOut[ki + roomSize / 2 - 1][kj+roomSize-1] = 2;
                            }
                        }
                    }
                }
            }
        }
    }
    void print(){
        for(int i = 0; i<layOut.length; i++){
            for(int j = 0; j<layOut.length; j++){
                if(layOut[i][j] == 0)
                    System.out.print("   ");
                if(layOut[i][j] == 1)
                    System.out.print("#  ");
                if(layOut[i][j] == 2)
                    System.out.print("-  ");
            }
            System.out.println();
        }
    }
}

