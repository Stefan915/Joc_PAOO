package MapGeneration;
import Mathf.Rand;

enum extendedRoomTypes
{
    WALL,
    KEY,
    CHEST,
    DOOR,
    EXIT,
    NOTHING,
    ENEMY,
    FLOOR,
    ENTRANCE
}




public class layout {
    private extendedRoomTypes[][] layOut;
    private extendedRoomTypes[][] floorLayout;

    public layout(int roomSize, roomTypes[][] base, int enemiesPerRoomMin, int enemiesPerRoomMax) {
        int baseSize = base[0].length;

        layOut = new extendedRoomTypes[roomSize * baseSize][roomSize * baseSize];
        floorLayout = new extendedRoomTypes[roomSize * baseSize][roomSize * baseSize];

        for(int i=0;i<roomSize*baseSize;i++)
        {
            for(int j=0;j<roomSize*baseSize;j++)
            {
                layOut[i][j]=extendedRoomTypes.NOTHING;
                floorLayout[i][j]=extendedRoomTypes.NOTHING;
            }

        }




        for (int ki = 0; ki < roomSize * baseSize; ki += roomSize) {
            for (int kj = 0; kj < roomSize * baseSize; kj += roomSize) {
                roomTypes currentRoom;
                currentRoom = base[ki / roomSize][kj / roomSize];
                if (currentRoom != roomTypes.NOTHING) {


                    for (int i = ki; i < ki + roomSize; i++) {
                        for (int j = kj; j < kj + roomSize; j++) {
                            if (j == kj || j + 1 == kj + roomSize || i + 1 == ki + roomSize || i == ki) {
                                layOut[i][j] = extendedRoomTypes.WALL;
                            }
                            else
                            {
                                floorLayout[i][j]=extendedRoomTypes.FLOOR;
                            }
                        }
                    }

                    //usa sus
                    if (ki / roomSize - 1 >= 0) {
                        if (base[ki / roomSize - 1][kj / roomSize] != roomTypes.NOTHING) {
                            if (roomSize % 2 == 1) {
                                layOut[ki][kj + roomSize / 2] = extendedRoomTypes.DOOR;
                                layOut[ki][kj + roomSize / 2 + 1] = extendedRoomTypes.DOOR;
                                layOut[ki][kj + roomSize / 2 - 1] = extendedRoomTypes.DOOR;
                            } else {
                                layOut[ki][kj + roomSize / 2] = extendedRoomTypes.DOOR;
                                layOut[ki][kj + roomSize / 2 - 1] = extendedRoomTypes.DOOR;
                            }
                        }
                    }
                    //usa jos
                    if (ki / roomSize + 1 < baseSize) {
                        if (base[ki / roomSize + 1][kj / roomSize] != roomTypes.NOTHING) {
                            if (roomSize % 2 == 1) {
                                layOut[ki + roomSize - 1][kj + roomSize / 2] = extendedRoomTypes.DOOR;
                                layOut[ki + roomSize - 1][kj + roomSize / 2 + 1] = extendedRoomTypes.DOOR;
                                layOut[ki + roomSize - 1][kj + roomSize / 2 - 1] = extendedRoomTypes.DOOR;
                            } else {
                                layOut[ki + roomSize - 1][kj + roomSize / 2] = extendedRoomTypes.DOOR;
                                layOut[ki + roomSize - 1][kj + roomSize / 2 - 1] = extendedRoomTypes.DOOR;
                            }
                        }
                    }
                    //usa stanga
                    if (kj / roomSize - 1 >= 0) {
                        if (base[ki / roomSize][kj / roomSize - 1] != roomTypes.NOTHING) {
                            if (roomSize % 2 == 1) {
                                layOut[ki + roomSize / 2 + 1][kj] = extendedRoomTypes.DOOR;
                                layOut[ki + roomSize / 2][kj] = extendedRoomTypes.DOOR;
                                layOut[ki + roomSize / 2 - 1][kj] = extendedRoomTypes.DOOR;
                            } else {
                                layOut[ki + roomSize / 2][kj] = extendedRoomTypes.DOOR;
                                layOut[ki + roomSize / 2 - 1][kj] = extendedRoomTypes.DOOR;
                            }
                        }
                    }
                    //usa dreapta
                    if (kj / roomSize + 1 < baseSize) {
                        if (base[ki / roomSize][kj / roomSize + 1] != roomTypes.NOTHING) {
                            if (roomSize % 2 == 1) {
                                layOut[ki + roomSize / 2 + 1][kj + roomSize - 1] = extendedRoomTypes.DOOR;
                                layOut[ki + roomSize / 2][kj + roomSize - 1] = extendedRoomTypes.DOOR;
                                layOut[ki + roomSize / 2 - 1][kj + roomSize - 1] = extendedRoomTypes.DOOR;
                            } else {
                                layOut[ki + roomSize / 2][kj + roomSize - 1] = extendedRoomTypes.DOOR;
                                layOut[ki + roomSize / 2 - 1][kj + roomSize - 1] = extendedRoomTypes.DOOR;
                            }
                        }
                    }


                    //adaugare chest-uri
                    if (currentRoom == roomTypes.CHEST) {
                        layOut[ki + roomSize / 2][kj + roomSize/2] = extendedRoomTypes.CHEST;
                    }

                    //adaugare cheie
                    if(currentRoom==roomTypes.KEY)
                    {
                        layOut[ki + roomSize / 2][kj + roomSize/2] = extendedRoomTypes.KEY;
                    }

                    //adaugare iesire

                    if(currentRoom==roomTypes.EXIT)
                    {
                        layOut[ki + roomSize / 2][kj + roomSize/2] = extendedRoomTypes.EXIT;
                    }

                    //adaugare intrare
                    if(currentRoom==roomTypes.ENTRANCE)
                    {
                        layOut[ki + roomSize / 2][kj + roomSize/2] = extendedRoomTypes.ENTRANCE;
                    }


                    //adaugare inamici
                    int enemiesCount;

                    enemiesCount= Rand.Range(enemiesPerRoomMin,enemiesPerRoomMax+1);

                    while(enemiesCount!=0)
                    {
                        mapCoordinates randomCoordinates;
                        randomCoordinates=new mapCoordinates(Rand.Range(ki+2,ki+roomSize-2), Rand.Range(kj+2,kj+roomSize-2));

                        if(layOut[randomCoordinates.x][randomCoordinates.y]==extendedRoomTypes.NOTHING) {
                            layOut[randomCoordinates.x][randomCoordinates.y] = extendedRoomTypes.ENEMY;
                            enemiesCount--;
                        }
                    }
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < layOut.length; i++) {
            for (int j = 0; j < layOut.length; j++) {

                if(layOut[i][j]!=extendedRoomTypes.NOTHING) {
                    switch (layOut[i][j]) {
                        case WALL: {
                            System.out.print("■  ");
                            break;
                        }
                        case DOOR: {
                            System.out.print("≡  ");
                            break;
                        }
                        case KEY: {
                            System.out.print("?  ");
                            break;
                        }
                        case EXIT: {
                            System.out.print("E  ");
                            break;
                        }
                        case CHEST: {
                            System.out.print("C  ");
                            break;
                        }
                        case ENEMY: {
                            System.out.print("N  ");
                            break;
                        }
                        case FLOOR: {
                            System.out.print(".  ");
                            break;
                        }
                        case ENTRANCE:
                        {
                            System.out.print("I  ");
                            break;
                        }
                        default: {
                            System.out.print("   ");
                            break;
                        }

                    }
                }
                else
                {
                    if(floorLayout[i][j]==extendedRoomTypes.FLOOR)
                    {
                        System.out.print(".  ");
                    }
                    else
                    {
                        System.out.print("   ");

                    }
                }
            }
            System.out.println();
        }
    }
}

