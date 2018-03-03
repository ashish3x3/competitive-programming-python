package chap01;

public class Q7 {
    //Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
    //column are set to 0.
    
    // use boolean array
    static void setZeros(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];
        
        // mark zero
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    rows[i] = cols[j] = true;
                }
            }
        }
        
        // set zeros
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    // use bit vector
    static void setZeros2(int[][] matrix) {
        long bitVecRows = 0;
        long bitVecCols = 0;
        
        // mark zero
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    bitVecRows |= 1l << i;
                    bitVecCols |= 1l << j; 
                }
            }
        }
        
        // set zeros
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if ((bitVecRows & (1l << i)) != 0 || (bitVecCols & (1l << j)) != 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    //-----------------------------------------------------
    public static void main(String[] args) {
//        int[][] a = {{0,2,3,4,5},
//                    {1,2,3,4,5},
//                    {5,4,3,0,1},
//                    {5,4,3,2,1},
//                    {6,7,8,9,0}};
        int[][]a={{-361,-425,-367,381,-264,473,411,-218,-376,-74,-83,329,-367,313,-397,402,-245,-437,-177,-453,324,142,-319,160,16,488,-297,120,-156,489,91,325,115,180,50,-193,230,424,198,-75,333,-408,425,-103,-460,-188,-43,268,302,-173,186},{-314,199,363,116,325,-331,79,189,-317,-156,297,-66,282,272,-292,35,-84,10,-217,-130,-232,-283,-61,168,418,146,247,343,-234,95,463,5,-68,-367,-371,-257,-355,244,114,-134,311,-443,-448,-461,402,-472,1,-279,-315,-30,204},{-420,166,-299,43,317,-415,139,-482,29,375,188,269,-389,416,73,-470,110,88,-168,-40,-310,273,-83,-348,-175,-332,-376,383,76,428,53,165,-136,-263,443,493,328,292,366,79,-12,-352,-368,450,366,-40,92,484,7,-479,-292},{-255,142,240,249,-492,-153,-108,-446,37,367,0,-363,-35,415,299,-180,240,269,-487,-120,236,-188,344,-359,98,-250,-463,18,-274,-415,28,72,-190,326,376,184,-256,200,462,-284,-328,85,417,211,31,-232,-141,352,485,379,-303},{197,-250,9,131,268,-320,-249,426,477,-466,-125,-25,358,-154,436,93,-381,-150,269,-466,275,-279,397,191,45,-339,418,135,-475,20,-371,77,-240,370,-449,98,-433,407,-446,27,-322,-250,-394,-408,150,204,-219,21,315,370,302},{88,0,-406,377,467,368,-146,289,327,225,-58,405,5,-432,-284,-215,453,-109,130,-247,-430,134,-400,490,54,-149,493,461,366,432,313,244,-236,-343,441,-54,198,-21,14,154,-16,160,343,-69,271,437,-431,58,426,19,-84},{-256,168,-369,53,276,-333,-71,451,-190,222,212,255,-441,409,155,381,-343,356,-492,-53,-406,-213,317,-286,95,35,-332,-100,415,-147,-233,-77,347,468,-493,347,215,-373,271,-452,138,-246,31,287,-422,-239,177,-225,93,273,-170},{-339,-344,356,307,-350,316,240,-75,-236,-74,322,-353,-422,293,-163,-29,-457,172,446,83,220,-457,-473,259,-33,91,-109,165,352,-445,465,-103,-353,125,24,-456,33,-347,-177,259,-167,-75,188,-428,440,36,96,-225,-301,269,212},{-56,257,289,-263,-362,-231,481,-127,171,-410,-160,377,-414,396,53,488,-235,345,497,449,221,-388,-344,-16,197,423,-142,-79,36,-486,288,56,193,342,-117,380,216,104,377,354,-445,-14,438,483,-46,179,370,207,387,55,364},{35,-309,29,63,-461,146,-111,-436,157,-113,92,-2,185,334,-418,-467,47,116,403,-59,232,438,-467,-451,491,-62,240,-231,127,-483,17,115,86,-460,356,32,189,-86,12,328,-148,415,133,-487,-162,-77,403,-187,-399,441,224},{-482,-152,202,139,-250,449,-477,269,-99,155,454,111,212,-423,-395,216,76,-61,184,-328,-291,339,106,-431,272,-114,-8,-493,-321,-433,108,-274,-285,345,91,0,49,187,-14,277,-335,-142,309,-252,-395,133,-385,377,374,-208,60},{72,-83,-200,-58,76,-72,-203,-314,227,374,68,-231,148,17,281,215,220,335,-222,-214,-90,48,-397,38,421,-329,498,-158,183,283,-220,-216,0,-240,379,-198,-473,-261,-23,338,433,228,-249,-201,101,84,364,-366,277,469,7},{186,-202,306,-34,-13,-16,-96,-59,90,-322,-329,-327,-224,408,-463,-235,-48,-17,-163,-30,-199,250,432,298,154,-231,-245,267,222,79,197,114,-33,-259,-31,158,213,-440,101,-84,-414,-421,80,-319,398,-430,148,306,421,155,392},{-331,-223,499,163,17,-291,-435,364,154,31,249,-422,84,346,-442,327,-270,-212,-254,332,-212,315,221,453,58,-317,231,458,-420,-272,259,-211,-205,91,33,-48,279,-161,-410,181,-357,38,-147,416,-248,-233,49,-467,199,-205,316},{245,-363,41,83,-251,11,-298,-421,302,213,-117,226,-244,466,426,-468,-426,-109,-429,-122,341,181,437,-376,-248,-490,-298,-491,122,394,-125,-410,466,334,-448,-60,-33,166,232,-34,488,213,-435,-249,-474,-184,52,-4,-148,-119,37},{-97,128,-123,-459,31,387,119,-72,72,-160,-463,-94,-168,371,-355,180,231,176,394,-123,1,92,331,-320,33,153,-234,-280,-494,-293,417,464,-414,244,-411,448,-446,-319,-197,300,-139,-31,68,420,-160,293,201,-469,-421,-154,292},{-336,230,157,291,-15,-484,80,-287,-100,-163,-393,-107,-219,177,-393,314,388,433,351,-442,345,444,-159,-410,414,407,147,-103,49,287,460,256,406,67,234,-423,117,398,-257,146,376,-193,-55,-183,-106,217,183,187,218,128,-7},{403,-410,-335,-145,-401,362,-28,-2,186,-218,206,-464,193,-17,466,-168,-388,229,299,394,94,92,-444,388,-328,-37,198,-146,304,-447,-436,25,125,423,-65,304,-205,-446,-29,-196,-313,439,-37,300,450,101,-274,60,-338,258,-419},{415,-488,136,45,247,280,193,486,259,-162,-133,-47,-383,-63,5,13,440,290,-387,0,-42,205,-158,404,-247,84,-97,-143,411,11,11,30,204,226,436,287,411,0,394,-352,-35,-430,231,25,0,141,-480,-390,309,476,-227},{-252,314,217,71,-123,-458,-376,22,305,-90,388,82,-375,-347,433,125,-334,-412,255,-417,-287,-443,-467,237,-277,81,129,162,-193,-199,407,-420,54,-229,-313,133,0,-142,-377,67,-97,61,189,-207,112,-39,467,228,236,-450,138},{237,-394,223,313,295,-249,-156,327,11,408,72,128,-130,159,-28,222,-95,288,31,39,113,316,335,-231,-468,-232,196,0,-438,107,232,0,-311,-86,-337,-415,-422,310,111,-187,448,464,-365,-131,275,323,351,-454,123,-37,-88},{241,-108,81,-390,-153,305,394,-452,-269,-303,-435,-69,368,-67,207,-350,-124,487,-254,261,-159,61,184,11,-466,-428,45,-122,282,-268,167,-73,-242,460,-469,-218,68,62,-3,-162,488,-122,-131,237,-155,148,363,275,77,23,374},{141,385,-142,-424,-48,444,305,0,-180,-245,-374,436,-25,-307,-398,369,-140,-422,-274,154,255,198,-115,95,295,-362,11,371,-370,-180,175,202,-145,-147,336,408,-13,454,189,396,378,303,-461,376,59,205,-239,96,-256,-141,-110},{-417,112,163,-165,-265,325,209,-139,485,428,-495,388,-104,-290,282,341,-331,3,-102,320,-240,313,352,-85,-72,17,-13,7,108,-457,-165,-353,-280,-111,-215,358,-364,444,439,132,-155,152,-362,447,493,339,473,282,66,131,0},{155,169,247,-121,69,-255,396,148,-323,377,-477,-328,61,-85,171,-325,264,431,-470,-161,161,324,162,-326,-106,44,465,-301,-469,-304,252,319,-175,-271,-80,-320,-450,365,-215,-27,-29,348,-16,93,-166,-110,-399,-148,140,-346,-427},{0,-78,-486,-300,274,-155,-409,-189,464,-390,220,273,75,-397,-25,426,-402,320,246,59,-290,434,-63,68,-318,-276,489,309,0,-482,-461,-6,-47,-274,-285,-204,40,-200,-23,-323,196,10,-242,467,-435,-170,-450,179,-379,446,-142},{-257,226,-464,39,121,-486,179,-157,-445,-228,-263,-113,473,-116,-33,-427,-190,24,-450,-497,-361,405,-166,169,-145,115,382,273,-223,475,375,-179,-115,-499,19,-147,-371,222,-210,-279,157,-461,-303,8,-342,-40,31,-356,-39,384,-387},{114,-118,417,34,260,-64,-326,-173,-179,468,119,311,-365,-75,164,133,0,-340,363,52,-360,-305,190,-170,-293,450,320,464,-273,-279,73,-269,-133,435,-208,-213,-366,493,-120,-426,378,447,-150,498,420,-431,-312,0,-139,-435,-60},{-80,-447,-203,-372,245,-478,-186,186,-103,218,455,-436,442,261,101,26,254,280,-223,-361,73,454,-210,136,-355,-446,427,417,-203,425,143,289,-310,-262,368,22,-54,150,496,-399,-78,136,-360,-45,-452,-331,-264,-4,-185,176,-396},{-214,-289,330,327,133,48,203,-162,481,437,-175,483,228,-320,-479,-375,266,450,-423,-288,125,-216,-479,-105,48,-343,-106,-194,439,222,-439,158,-166,295,-224,85,-280,-160,442,255,-390,-372,38,-262,-218,-235,-42,-51,-66,-8,-19},{-224,-190,194,396,-493,-180,-417,-248,-262,-31,-348,-371,-117,-383,245,-139,495,177,126,450,39,-265,-371,415,-171,-23,12,-394,-31,-487,431,289,-253,-17,476,-475,-196,-406,3,453,-434,148,466,-208,-55,456,197,-127,423,-414,50},{19,438,-383,64,210,140,0,335,378,-333,335,-322,398,82,-348,-25,13,-365,438,-37,-243,-410,-4,-380,447,-13,274,7,191,-35,-294,-135,-202,376,-75,9,-170,71,-252,238,420,429,439,349,92,-17,149,-206,-349,73,62},{60,-33,282,391,-456,-45,-433,-127,319,396,3,-424,65,-154,-268,267,-322,-208,0,414,0,-303,473,-104,-491,151,235,300,-196,-348,318,18,-481,-343,494,242,-133,-100,-473,-221,-92,-440,41,-461,-206,396,-446,-30,-357,104,335},{499,102,-267,154,401,-12,-74,35,-295,202,-222,373,-192,-319,100,128,186,-226,72,447,295,-407,121,-454,-114,348,251,57,-124,408,-393,281,-323,138,233,9,-477,359,-247,-436,127,-42,259,-470,143,-229,357,213,-376,-418,139},{-185,111,-243,387,-9,457,-334,198,24,-222,37,249,-33,-233,229,382,22,8,-440,-253,426,-3,-94,170,-22,-83,210,264,327,-464,166,-119,-434,-59,-380,260,8,459,-310,-438,361,-321,67,-483,-304,257,430,0,-455,-107,-54},{224,-266,-480,-34,452,-19,95,-295,298,-421,-478,-441,-243,149,334,-115,296,-41,160,-442,397,-402,25,-101,-82,430,-222,453,282,111,-199,270,-442,-196,-418,-412,346,-166,-19,205,-144,-315,363,179,-265,-159,-271,-102,-193,205,80},{-66,418,-13,-102,470,-343,-149,192,254,447,322,352,-276,-346,-278,-187,67,289,372,21,84,172,204,156,496,-33,-240,221,-20,491,-270,-71,164,414,424,-368,384,-327,-239,376,333,-136,-285,-260,56,154,241,-238,-433,-199,-113},{-57,-406,-365,-442,-133,-472,-255,351,-280,237,-492,-116,273,378,58,331,432,-188,0,-319,255,284,397,205,412,-377,-193,246,173,-25,64,198,-481,483,-294,398,269,162,133,-461,-89,-157,-486,200,179,-332,490,-290,68,-368,-9},{246,216,-167,452,189,402,-489,-196,198,-223,483,177,-342,-258,422,85,-164,175,101,-109,436,444,266,307,246,-63,304,-409,0,337,390,204,493,-130,-362,434,-397,92,-66,167,116,102,302,207,426,233,362,0,309,-256,130},{369,-121,447,210,-305,147,-187,-40,-149,-205,-97,29,-200,-238,-7,292,-491,-400,-233,10,-495,347,15,-208,202,84,-216,-280,288,-498,391,-41,-365,-14,-50,280,201,2,-223,-364,280,-66,457,2147483647,447,292,182,110,-30,473,153},{214,354,-293,35,486,-380,-284,-330,-456,362,441,84,-158,27,-243,-290,-16,-129,-352,196,-147,-418,-171,-59,233,282,-92,125,208,-369,411,400,-189,71,-286,320,53,473,411,-322,-125,-57,406,-35,267,402,377,-413,435,0,-452},{142,-488,309,368,47,-479,462,-121,164,313,-330,-117,-361,-487,133,268,296,192,367,-346,402,-445,233,302,-270,-41,194,144,-325,-238,187,-316,-316,-293,-319,442,-493,-435,240,74,-102,-449,-290,133,170,182,142,-494,-283,23,116},{-262,-257,187,354,-28,-103,125,-238,267,154,383,-325,92,34,-470,491,293,313,438,447,-294,76,-288,-211,218,-492,323,-411,-37,226,93,-252,-109,55,91,98,31,-369,497,239,-45,3,-86,237,-196,-229,-383,452,-396,357,-283},{-468,-191,390,-128,122,216,235,292,-74,-307,-435,211,-448,-350,-2147483648,-279,491,-161,-194,273,-499,173,-231,-264,-468,221,-461,438,398,-52,-331,55,-268,211,310,-389,-18,-432,-422,268,-425,-179,-241,413,44,346,451,350,-55,-260,91},{-47,-153,141,126,78,70,414,-198,-171,-238,378,352,-426,-313,175,252,212,339,-54,-479,391,264,396,200,-72,-210,67,-343,-243,-82,452,400,81,486,243,0,-469,-275,249,358,45,40,-343,233,-374,295,-247,443,-426,398,-192},{197,-383,144,-386,327,-383,121,235,470,258,53,0,-146,-13,-301,441,-402,-460,-68,-231,200,163,-316,39,-263,79,438,-135,-392,311,-85,411,24,-273,339,-254,-49,402,196,253,-184,-393,-134,55,-371,-385,-388,-432,33,-55,-434},{369,-25,70,-42,204,-340,-388,-334,70,261,491,-24,-236,-49,6,8,457,255,-452,300,-187,-7,-42,-51,-406,-491,399,-62,-15,-16,-147,483,-48,116,378,-38,289,-18,0,392,-220,444,382,-328,-331,397,-238,-459,20,372,-167},{-94,-11,313,-199,-428,-343,-342,-192,-260,210,41,-89,254,151,160,-171,-473,-232,-416,-212,-193,155,332,54,151,373,-162,127,286,69,-86,487,284,290,-203,157,-291,150,278,-84,-130,-456,-5,-179,-480,422,-324,-364,69,413,254},{-287,369,-334,88,429,-82,-415,349,-228,269,-409,488,-290,-458,195,159,-492,-48,-403,196,-205,-92,361,191,416,-309,-47,-142,15,284,203,59,-426,137,134,-492,147,14,145,418,306,-365,-139,-420,-313,-70,-350,-145,355,-32,-428},{43,-27,-387,20,342,161,-228,-482,-142,-345,-145,251,-293,407,81,-306,-230,219,66,-247,-362,482,-245,-71,478,36,446,-1,-410,408,-219,-92,52,-340,476,154,387,-404,-186,-81,-286,-93,-107,121,245,-62,24,419,-260,319,491}};
        setZeros2(a);
        printArray(a);
    }
    
    private static void printArray(int[][] a) {
        for (int[] row : a) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
