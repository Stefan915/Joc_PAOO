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
    private LayoutInfo layoutInfo;

    public layout(int roomSize, roomTypes[][] base, int enemiesPerRoomMin, int enemiesPerRoomMax) {
        int baseSize = base[0].length;

        layoutInfo=new LayoutInfo();

        layoutInfo.layOut = new extendedRoomTypes[roomSize * baseSize][roomSize * baseSize];
        layoutInfo.floorLayout = new extendedRoomTypes[roomSize * baseSize][roomSize * baseSize];

        for(int i=0;i<roomSize*baseSize;i++)
        {
            for(int j=0;j<roomSize*baseSize;j++)
            {
                layoutInfo.layOut[i][j]=extendedRoomTypes.NOTHING;
                layoutInfo.floorLayout[i][j]=extendedRoomTypes.NOTHING;
            }

        }




        for (int ki = 0; ki < roomSize * baseSize; ki += roomSize) {
            for (int kj = 0; kj < roomSize * baseSize; kj += roomSize) {
                roomTypes currentRoom;
                currentRoom = base[ki / roomSize][kj / roomSize];
                if (currentRoom != roomTypes.NOTHING) {


                    for (int i = ki+1; i < ki + roomSize-1; i++) {
                        for (int j = kj+1; j < kj + roomSize-1; j++) {
                            if (j == kj+1 || j + 1 == kj + roomSize-1 || i + 1 == ki + roomSize-1 || i == ki+1) {
                                layoutInfo.layOut[i][j] = extendedRoomTypes.WALL;
                            }
                            else
                            {
                                layoutInfo.floorLayout[i][j]=extendedRoomTypes.FLOOR;
                            }
                        }
                    }

                    //usa sus
                    if (ki / roomSize - 1 >= 0) {
                        if (base[ki / roomSize - 1][kj / roomSize] != roomTypes.NOTHING) {
                            if (roomSize % 2 == 1) {
                                layoutInfo.layOut[ki+1][kj + roomSize / 2] = extendedRoomTypes.DOOR;
                                layoutInfo.layOut[ki+1][kj + roomSize / 2 + 1] = extendedRoomTypes.DOOR;
                                layoutInfo.layOut[ki+1][kj + roomSize / 2 - 1] = extendedRoomTypes.DOOR;

                                layoutInfo.floorLayout[ki+1][kj + roomSize / 2] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki+1][kj + roomSize / 2 + 1] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki+1][kj + roomSize / 2 - 1] = extendedRoomTypes.FLOOR;

                                layoutInfo.floorLayout[ki][kj + roomSize / 2] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki][kj + roomSize / 2 + 1] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki][kj + roomSize / 2 - 1] = extendedRoomTypes.FLOOR;

                                layoutInfo.layOut[ki][kj + roomSize / 2-2] = extendedRoomTypes.WALL;
                                layoutInfo.layOut[ki][kj + roomSize / 2+2] = extendedRoomTypes.WALL;
                            } else {
                                layoutInfo.layOut[ki+1][kj + roomSize / 2] = extendedRoomTypes.DOOR;
                                layoutInfo.layOut[ki+1][kj + roomSize / 2 - 1] = extendedRoomTypes.DOOR;

                                layoutInfo.floorLayout[ki+1][kj + roomSize / 2] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki+1][kj + roomSize / 2 - 1] = extendedRoomTypes.FLOOR;

                                layoutInfo.floorLayout[ki][kj + roomSize / 2] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki][kj + roomSize / 2 - 1] = extendedRoomTypes.FLOOR;

                                layoutInfo.layOut[ki][kj + roomSize / 2+1] = extendedRoomTypes.WALL;
                                layoutInfo.layOut[ki][kj + roomSize / 2-2] = extendedRoomTypes.WALL;

                            }
                        }
                    }
                    //usa jos
                    if (ki / roomSize + 1 < baseSize) {
                        if (base[ki / roomSize + 1][kj / roomSize] != roomTypes.NOTHING) {
                            if (roomSize % 2 == 1) {
                                layoutInfo.layOut[ki + roomSize - 2][kj + roomSize / 2] = extendedRoomTypes.DOOR;
                                layoutInfo.layOut[ki + roomSize - 2][kj + roomSize / 2 + 1] = extendedRoomTypes.DOOR;
                                layoutInfo.layOut[ki + roomSize - 2][kj + roomSize / 2 - 1] = extendedRoomTypes.DOOR;

                                layoutInfo.floorLayout[ki + roomSize - 2][kj + roomSize / 2] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki + roomSize - 2][kj + roomSize / 2 + 1] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki + roomSize - 2][kj + roomSize / 2 - 1] = extendedRoomTypes.FLOOR;

                                layoutInfo.floorLayout[ki + roomSize - 1][kj + roomSize / 2] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki + roomSize - 1][kj + roomSize / 2 + 1] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki + roomSize - 1][kj + roomSize / 2 - 1] = extendedRoomTypes.FLOOR;

                                layoutInfo.layOut[ki + roomSize - 1][kj + roomSize / 2-2] = extendedRoomTypes.WALL;
                                layoutInfo.layOut[ki + roomSize - 1][kj + roomSize / 2+2] = extendedRoomTypes.WALL;

                            } else {
                                layoutInfo.layOut[ki + roomSize - 2][kj + roomSize / 2] = extendedRoomTypes.DOOR;
                                layoutInfo.layOut[ki + roomSize - 2][kj + roomSize / 2 - 1] = extendedRoomTypes.DOOR;

                                layoutInfo.floorLayout[ki + roomSize - 2][kj + roomSize / 2] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki + roomSize - 2][kj + roomSize / 2 - 1] = extendedRoomTypes.FLOOR;

                                layoutInfo.floorLayout[ki + roomSize - 1][kj + roomSize / 2] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki + roomSize - 1][kj + roomSize / 2 - 1] = extendedRoomTypes.FLOOR;

                                layoutInfo.layOut[ki + roomSize - 1][kj + roomSize / 2+1] = extendedRoomTypes.WALL;
                                layoutInfo.layOut[ki + roomSize - 1][kj + roomSize / 2 - 2] = extendedRoomTypes.WALL;
                            }
                        }
                    }
                    //usa stanga
                    if (kj / roomSize - 1 >= 0) {
                        if (base[ki / roomSize][kj / roomSize - 1] != roomTypes.NOTHING) {
                            if (roomSize % 2 == 1) {
                                layoutInfo.layOut[ki + roomSize / 2 + 1][kj+1] = extendedRoomTypes.DOOR;
                                layoutInfo.layOut[ki + roomSize / 2][kj+1] = extendedRoomTypes.DOOR;
                                layoutInfo.layOut[ki + roomSize / 2 - 1][kj+1] = extendedRoomTypes.DOOR;

                                layoutInfo.floorLayout[ki + roomSize / 2 + 1][kj+1] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki + roomSize / 2][kj+1] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki + roomSize / 2 - 1][kj+1] = extendedRoomTypes.FLOOR;

                                layoutInfo.floorLayout[ki + roomSize / 2 + 1][kj] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki + roomSize / 2][kj] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki + roomSize / 2 - 1][kj] = extendedRoomTypes.FLOOR;

                                layoutInfo.layOut[ki + roomSize / 2 + 2][kj] = extendedRoomTypes.WALL;
                                layoutInfo.layOut[ki + roomSize / 2 - 2][kj] = extendedRoomTypes.WALL;

                            } else {
                                layoutInfo.layOut[ki + roomSize / 2][kj+1] = extendedRoomTypes.DOOR;
                                layoutInfo.layOut[ki + roomSize / 2 - 1][kj+1] = extendedRoomTypes.DOOR;

                                layoutInfo.floorLayout[ki + roomSize / 2][kj+1] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki + roomSize / 2 - 1][kj+1] = extendedRoomTypes.FLOOR;

                                layoutInfo.floorLayout[ki + roomSize / 2][kj] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki + roomSize / 2 - 1][kj] = extendedRoomTypes.FLOOR;

                                layoutInfo.layOut[ki + roomSize / 2+1][kj] = extendedRoomTypes.WALL;
                                layoutInfo.layOut[ki + roomSize / 2 - 2][kj] = extendedRoomTypes.WALL;
                            }
                        }
                    }
                    //usa dreapta
                    if (kj / roomSize + 1 < baseSize) {
                        if (base[ki / roomSize][kj / roomSize + 1] != roomTypes.NOTHING) {
                            if (roomSize % 2 == 1) {
                                layoutInfo.layOut[ki + roomSize / 2 + 1][kj + roomSize - 2] = extendedRoomTypes.DOOR;
                                layoutInfo.layOut[ki + roomSize / 2][kj + roomSize - 2] = extendedRoomTypes.DOOR;
                                layoutInfo.layOut[ki + roomSize / 2 - 1][kj + roomSize - 2] = extendedRoomTypes.DOOR;

                                layoutInfo.floorLayout[ki + roomSize / 2 + 1][kj + roomSize - 2] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki + roomSize / 2][kj + roomSize - 2] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki + roomSize / 2 - 1][kj + roomSize - 2] = extendedRoomTypes.FLOOR;

                                layoutInfo.floorLayout[ki + roomSize / 2 + 1][kj + roomSize - 1] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki + roomSize / 2][kj + roomSize - 1] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki + roomSize / 2 - 1][kj + roomSize - 1] = extendedRoomTypes.FLOOR;


                                layoutInfo.layOut[ki + roomSize / 2 + 2][kj + roomSize - 1] = extendedRoomTypes.WALL;
                                layoutInfo.layOut[ki + roomSize / 2 - 2][kj + roomSize - 1] = extendedRoomTypes.WALL;


                            } else {
                                layoutInfo.layOut[ki + roomSize / 2][kj + roomSize - 2] = extendedRoomTypes.DOOR;
                                layoutInfo.layOut[ki + roomSize / 2 - 1][kj + roomSize - 2] = extendedRoomTypes.DOOR;

                                layoutInfo.floorLayout[ki + roomSize / 2][kj + roomSize - 2] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki + roomSize / 2 - 1][kj + roomSize - 2] = extendedRoomTypes.FLOOR;

                                layoutInfo.floorLayout[ki + roomSize / 2][kj + roomSize - 1] = extendedRoomTypes.FLOOR;
                                layoutInfo.floorLayout[ki + roomSize / 2 - 1][kj + roomSize - 1] = extendedRoomTypes.FLOOR;

                                layoutInfo.layOut[ki + roomSize / 2+1][kj + roomSize - 1] = extendedRoomTypes.WALL;
                                layoutInfo.layOut[ki + roomSize / 2 - 2][kj + roomSize - 1] = extendedRoomTypes.WALL;
                            }
                        }
                    }


                    //adaugare chest-uri
                    if (currentRoom == roomTypes.CHEST) {
                        layoutInfo.layOut[ki + roomSize / 2][kj + roomSize/2] = extendedRoomTypes.CHEST;
                    }

                    //adaugare cheie
                    if(currentRoom==roomTypes.KEY)
                    {
                        layoutInfo.layOut[ki + roomSize / 2][kj + roomSize/2] = extendedRoomTypes.KEY;
                    }

                    //adaugare iesire

                    if(currentRoom==roomTypes.EXIT)
                    {
                        layoutInfo.layOut[ki + roomSize / 2][kj + roomSize/2] = extendedRoomTypes.EXIT;
                    }

                    //adaugare intrare
                    if(currentRoom==roomTypes.ENTRANCE)
                    {
                        layoutInfo.layOut[ki + roomSize / 2][kj + roomSize/2] = extendedRoomTypes.ENTRANCE;
                    }


                    //adaugare inamici
                    int enemiesCount;

                    enemiesCount= Rand.Range(enemiesPerRoomMin,enemiesPerRoomMax+1);

                    while(enemiesCount!=0)
                    {
                        mapCoordinates randomCoordinates;
                        randomCoordinates=new mapCoordinates(Rand.Range(ki+3,ki+roomSize-3), Rand.Range(kj+3,kj+roomSize-3));

                        if(layoutInfo.layOut[randomCoordinates.x][randomCoordinates.y]==extendedRoomTypes.NOTHING) {
                            layoutInfo.layOut[randomCoordinates.x][randomCoordinates.y] = extendedRoomTypes.ENEMY;
                            enemiesCount--;
                        }
                    }
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < layoutInfo.layOut.length; i++) {
            for (int j = 0; j < layoutInfo.layOut.length; j++) {

                if(layoutInfo.layOut[i][j]!=extendedRoomTypes.NOTHING) {
                    switch (layoutInfo.layOut[i][j]) {
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
                    if(layoutInfo.floorLayout[i][j]==extendedRoomTypes.FLOOR)
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

    public LayoutInfo getLayoutInfo()
    {
        return layoutInfo;
    }
}

