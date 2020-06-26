package webdev;

public class poke {
    public int[] pokeInit(char[] type){
        for(int i = 0; i < 10; i = i + 2){
            if(type[i] == 'T')type[i] = 10;
            if(type[i] == 'J')type[i] = 11;
            if(type[i] == 'Q')type[i] = 12;
            if(type[i] == 'K')type[i] = 13;
            if(type[i] == 'A')type[i] = 14;
        }

        int[] typeInt = new int[5];
        for(int i = 0; i < 10; i = i + 2){
            typeInt[i] = Integer.parseInt(String.valueOf(type[i]));
        }

        for(int i = 0; i < 4; i = i ++){
            for(int j = 0; j < 4 - i; j ++){
                if(typeInt[j] > typeInt[j + 1]){
                    int p = typeInt[j];
                    typeInt[j] = typeInt[j + 1];
                    typeInt[j + 1] = p;
                }
            }
        }

        return typeInt;
    }

    public String pokeCmp(char[] black, char[] white) {
        int[] blackinit = new int[5];
        int[] whiteinit = new int[5]; 
        blackinit = pokeInit(black);
        whiteinit = pokeInit(white);
        if(pokeType(black) > pokeType(white))return "White wins";
        if(pokeType(black) < pokeType(white))return "Black wins";
        else{
            if(pokeType(black) == 1){
                if(blackinit[4] > whiteinit[4])return "Black wins";
                if(blackinit[4] < whiteinit[4])return "White wins";
                else return "Tie";
            }
            if(pokeType(black) == 2){
                for(int i = 4; i >= 0; i --){
                    if(blackinit[4] > whiteinit[4]){
                        return "Black wins";
                    }
                    if(blackinit[4] < whiteinit[4]){
                        return "White wins";
                    }
                }
                return "Tie";
            }
            if(pokeType(black) == 3){
                if(blackinit[4] > whiteinit[4])return "Black wins";
                if(blackinit[4] < whiteinit[4])return "White wins";
                else return "Tie";
            }
            if(pokeType(black) == 4){
                int i, j;
                for(i = 0; i < 3; i ++){
                    if(black[i] == black[i + 1] && black[i + 1] == black[i + 2])
                    break;
                }
                for(j = 0; j < 3; j ++){
                    if(white[j] == white[j + 1] && white[j + 1] == white[j + 2])
                    break;
                }
                if(black[i] > white[j])return "Black wins";
                if(black[i] < white[j])return "White wins";
                else return "Tie";
            }
            if(pokeType(black) == 5){
                int i, j, p, q, x, y;
                for(i = 4; i > 0; i --){
                    if(black[i] == black[i - 1])
                        break;
                }
                for(j = i - 2; j > 0; j --){
                    if(black[j] == black[j - 1])
                        break;
                }
                for(p = 4; p > 0; p --){
                    if(white[p] == white[p - 1])
                        break;
                }
                for(q = p - 2; q > 0; q --){
                    if(white[q] == white[q - 1])
                        break;
                }
                if(black[i] > white[p])return "Black wins";
                if(black[i] < white[p])return "White wins";
                else{
                    if(black[j] > white[q])return "Black wins";
                    if(black[j] < white[q])return "White wins";
                    else{
                        for(x = 0; x < 5; x ++){
                            if(x != i && x != j && x != i - 1 && x != j - 1)
                                break;
                        }
                        for(y = 0; y < 5; y ++){
                            if(y != q && y != p && y != q - 1 && y != p - 1)
                                break;
                        }
                        if(black[x] > white[y])return "Black wins";
                        if(black[x] < white[y])return "White wins";
                        else return "Tie";
                    }
                }
            }
            if(pokeType(black) == 6){
                int i, p, j, q;
                for(i = 4; i > 0; i --){
                    if(black[i] == black[i - 1])
                        break;
                }
                for(p = 4; p > 0; p --){
                    if(white[p] == white[p - 1])
                        break;
                }
                if(black[i] > white[p])return "Black wins";
                if(black[i] < white[p])return "White wins";
                else{
                    for(j = 4, q = 4; j >= 0 && q >= 0; ){
                        if(j == i){
                            j = j - 2;
                        }
                        if(q == p){
                            q = q - 2;
                        }
                        if(black[j] > white[q])return "Black wins";
                        if(black[j] < white[q])return "White wins";
                    }
                    return "Tie";
                }
            }
            if(pokeType(black) == 7){
                for(int i = 4; i >= 0; i --){
                    if(black[i] > white[i])return "Black wins";
                    if(black[i] < white[i])return "White wins";
                }
                return "Tie";
            }
        }
        return null;
    }

    int pokeType(char[] type){        //返回1是同花顺；2是同花；3是顺子；4是三条；5是两对；6是对子；7是散牌。
        int[] pokeinit = new int [5];
        pokeinit = pokeInit(type);
        int copy = 0;
        if(type[1] == type[3] && type[3] == type[5] && type[5] == type[7] && type[7] == type[9]){
            if(pokeinit[0] == pokeinit[1] - 1 && pokeinit[1] == pokeinit[2] - 1 && pokeinit[2] == pokeinit[3] - 1 && pokeinit[3] == pokeinit[4] - 1){
                return 1;
            }
            else return 2;
        }
        if(pokeinit[0] == pokeinit[1] - 1 && pokeinit[1] == pokeinit[2] - 1 && pokeinit[2] == pokeinit[3] - 1 && pokeinit[3] == pokeinit[4] - 1)
            return 3;
        for(int i = 0; i < 3; i ++){
            if(pokeinit[i] == pokeinit[i + 1] && pokeinit[i + 1] == pokeinit[i + 2])
                return 4;
        }
        for(int j = 0; j < 4; j ++){
            if(pokeinit[j] == pokeinit[j + 1]){
                copy ++;
                j ++;
            }
        }
        if(copy == 2)return 4;
        if(copy == 1)return 5;
        if(copy == 0)return 6;
        return 0;
    }
}