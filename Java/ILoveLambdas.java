import java.util.Scanner;

public class ILoveLambdas {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int year = scanner.nextInt();
        scanner.nextLine();
        String month = scanner.nextLine();
        String months = "JanFebMarAprMayJunJulAugSepOctNovDec";
        if (months.contains(month)) {
            System.out.print((months.substring(0, 21).indexOf(month) % 2 == 0 || months.substring(21, 36).indexOf(month) % 2 == 0) ? "31": ((month.contains("Feb")) ? "30" : ((year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? "29" : "28")));
        } else {
            System.out.print("is not");
        }
        scanner.close();
    }
}

//                                          %**+-::::::-+*##                                           
//                                      +=:::::::::::::::::::-+#                                       
//                                   *:::=***::::::::::::::::::::=%                                    
//                                 +:::=***###-::::-:::::::::::::::=#                                  
//                               *::::*****###=--::::::::::::::::::::+                                 
//                              =::::**#%#****%+========--:::::::::::::#                               
//                             =::-+*#%%*******#********+====-::::::::::#                              
//                          #***##%##%%**######%#******++=+#***-::::::::-%                             
//                        #****#%%#%%##%%%%%#+-:-:::=:-:::=**%%#*=::--:::+                             
//                       #****##*##@###***####+::.-::=::=::##%##%%**---:::%                            
//                        %##*****#%*#=*****+=:.:-:=-::+=-::--+.=*#*#+--::#                            
//                          %****#%#**##*=---:.:::=.:-*-:=-:.=+::*##**##=:-                            
//                          #**#%%*#****::--:...==...*=*=.-=:.==:+*%%%%#+--                            
//                          #:+***##**++---:..-+..:-=-:-*+..+--#.-+####+=--                            
//                           ::=*-=:::=+-:..:+.:===:....:-*-.:+#.-==++**===                            
//                           %**+:=-*+++#.-*****-:..=:++==++*--*.-===+#*==#                            
//                           @**#****#+*-++++=:........:-::::-++.-=+=+=*=+                             
//                           @*#%%#%#*-##@%@@%-=.......++%@@@#==.-+*=+-+=%                             
//                           @#%##%#**:%-%#%@*..........+#@@#=+#:=+*===+#                              
//                            **-**##=:#-:++++..........-=*+*.-#-=+#*+##                               
//                             =.+*+.:-=-................::::--+==#*#**-%                              
//                             -:=:=..-=-.........:.....:::::-=-=+*****-#                              
//                             -==:=::-:*:.....::..:..=.::::--#:=+*++==-#                              
//                             -+=:=+.--*#:.....%+++++%::::-:#==+%+++==-#                              
//                             :++:-=-:=-++*:...=====+-:::-*+**=+*#++==:#                              
//                             ++=::#+-=+#++++=...:::.::+#+=**=+**#++-*=                               
//                             %+#=-=**:++**++++=*+--%=#*+++*++##*#+=+%+                               
//                              % #:-**#-#****++.::====**#+%#+##+%++=++                                
//                            *::.:=+=** *%%%+*:..::--==*-  #@ %% #+#+==--#                            
//                          #:..::::::+=#::--=-==+*:++**=#----+#+*+=-:::::::%                          
//                       *-:..::::::::=:+:::...:=**%%*#-:::::-:#==::::::::::::-==#                     
//                     %:::::::::::--:::-:.......:-..-:.....:::--::-::::-:::::::::::#                  
//                    +:::::::::::::=:-::=...................:-=#:=-:-=-::::::::::::-%                 
//               %%  +::::::::::::::---:=::==###=:....-=#*#@=-=-::+===:::::::::::::::+                 
//              *::::+-----::::::::::=-::::+*##**##+-#*####*+=::-++==:::-::::::::::::--:::=            
//             %=*#=+*===----:-----::+=::::::%##%@%%%@@%##%-:::::#*-===-::::--------:=::#=+            
//                %*==-=============-+::::::-****%@-@%%#***=:::::-++==---=======----=*=::=+@           
//                *=++=:-+**=========*::::::=*##@%#::###%@%#::::--*===============#=-:++-=%            
//              %:.=+===*+*++=====++++::::::::##*#-::****+:::::---+*++++++++++++#=:::+=*%              
//            @%%%+-:==-:=-=++=====-+%-=======-***----#*+-=++***==+ %*+++++++++=*++++=-.:+             
//           %%%%%%%#-+:=*++=++%%     +==========+====+===++***++-%      @*+=+::=*+++-::+-%@           
//         @%%%%@@@@@@  @@#+===%      #==============+++++#+++*++*       %=-===**#*+--@%%%%%%@         
//        %%%%%%%%%@@      **++        *=================+++++++#        +--:-=+%  ++@@@@@@@%%@        
//        @%%%%%%%%%%@                  -::::::::::::--===#*#+++           *+=#      @@%%%%%%%%%@      
//          @%%%%%%%%%@                 #::::*=+:::::::--+#%##*+                   @@%%%%%%%%%%%@      
//           @@@%%%%%%%@                 :::::*+**+===----=---====+@              @%%%%%%%%%%@@        
//             @@@%%%%%%%@               *.::-***+------------====+*@           @%%%%%%%%%@@@          
//               @@@%%%%%%@              %.::-+:+----===--=--#@@==+++         @%%%%%%%%@@@@            
//                 @@@%%%%%%@            :.:::::-----%%%%==-++==-*++*       @%%%%%%%%@@@               
//                   @@@%%%%%@        %+::.:::::#---==--==@%====#@++*     @%%%%%%%@@@                  
//                     @@@%%%%%@    #-:..::-:::::=--*%#======+%*%++++*%@%%%%%%%@@@                     
//                       @@@%%%%%@+-::.....:::--=*--=+#%%######+=++**+%%%%%%@@@@                       
//                         @@@%%%%--.......:::::::=-==+===+===++=++*%%%%%%@@@                          
//                      @%%@%%%%%*:...:=***=::::::-=*=+++=+#++**++++@%%%%@@#*%                         
//                      %@@%%%%@+....=*****#:::::::::::::::---++====+%@%%%@@@-=@                       
//                      %%#******##-+*##%@#%-.:::::::::::::::----=====+@@%%@@@=:+                      
//                    %+-#@***#%%@+###%##****:...::::::::::::=+---=======#@@@===--#                    
//                   *:....-#***###%#+*%%####-.....:::::::::::=----========+*++===--#                  
//                **:......:****##%-.....:---:......::::::::::::-----========#*#====-+                 
//               @--=......:+##**=:.................::::::::-+:::-----=====+#**#*====--#               
//              *:.::.......::::....................::::::::::::::****##+=+##%%#*+=====-=@             
//         %=:.:+..-==...........:::::..............::::::::::::::=###@@@%%%%%%%#%======-+:-*@         
//      =:.:::-=*...:--.....::::::::::..............::::::=+:::::::-%**#%#*#+###%%=======*---:::-=*@   
//     @---==:::+...:=-..:::::::::::::..............::::::::::::::::=**#%================*======----*  
//      ++:.:--:=:::::==:::::::::::::..............:::::==::::::::::--%*---==============*++========   
//     #.......::*::::::::::::::::::..............:::::::::::::::::::-------============++:=+*++++*    
//     %:...::--==-:::::==:::::::::...........:::::::::::::::::::::::::----+#%+=========#===----*#     
//      =::--=+:::=-::::::=:::::::........:::::::::::=+::::::::::::::::::-#%%#%========++=======---    
//       +-==:::::-+-:::::==:::::.....:::::::::::::::::::::===---:::::::-#%%%##*======+*====+=====+    
//     %=+-::::::::-+::::::--+::...::::::::::::::=+::::::::+###***+:::::#%%#*###=====+#+======+++#@    
//    #:.=:::::---=+:=-::::::::-=:::::::::::-::::::::::::::#**#%%%%##*+#%#**###%====*%*+**++====*==%   
//  %=:.:=-:-====:::::--::::::::::::+-::=+:::::::::::::::::-*******#%+-*#%%%%###=-=#+==*+++*++++*==-+% 
// #:...:-=+=+-::::::==-+:::::::::::::::::::::::::::::::::::=***####%####%%#****+=#+=====*+**%*++====-#