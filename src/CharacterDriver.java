
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

interface Accuracy
{   
    public int accuracyStat(int randomAccuracyStat);/*the randomAccuracyStat value will be  the random number that
    the user selects for their accuracy stat during character creation*/
}

class getAccuracy implements Accuracy
{
    @Override
    public int accuracyStat(int randomAccuracyStat)
    {
        return randomAccuracyStat;
    }
}
interface Attack
{                    //randomNum1 will be a value from a random number generator
    public int rollForAttack(int randomNum1, int randomAccuracyStat);/*randomAccuracyStat is the random number
    that the user selects for their accuracy stat during character creation*/
}

class getAttack implements Attack
{
    @Override
    public int rollForAttack(int randomNum1, int randomAccuracyStat)
    {
        return randomNum1 + randomAccuracyStat;
    }
}

interface Damage
{                    //randomNum2 will be a value from a random number generator
    public int rollForDamage(int randomNum2, int randomAttackStat);/*randomAttackStat is the random number
    that the user selects for their attack stat during character creation*/
}

class getDamage implements Damage
{
    @Override
    public int rollForDamage(int randomNum2, int randomAttackStat)
    {
        return randomNum2 + randomAttackStat;
    }
}

interface PhysicalDefense
{                       //randomNum3 will be a value from a random number generator
    public int rollForPhyDef(int randomNum3, int randomPhyDefStat);/*phyDefStat is the random number that the user selects for their physical defense stat
    during character creation*/
}

class getPhyDef implements PhysicalDefense
{
    @Override
    public int rollForPhyDef(int randomNum3, int randomPhyDefStat)
    {
        return randomNum3 + randomPhyDefStat;
    }
}

interface MagicalDefense
{
    public int rollForMagDef(int randomNum4, int randomMagDefStat);
}

class getMagDef implements MagicalDefense
{
    @Override
    public int rollForMagDef(int randomNum4, int randomMagDefStat)
    {
        return randomNum4 + randomMagDefStat;
    }
}

class Assassin//The stealthy class. They utilize daggers, swords, poison darts, & silenced ranged weapons
{
    Accuracy accuracy;
    Attack attack;
    Damage damage;
    PhysicalDefense physicalDefense;
    MagicalDefense magicalDefense;
    
    public Assassin(Accuracy accuracy, Attack attack, Damage damage, 
            PhysicalDefense physicalDefense, MagicalDefense magicalDefense)
    {
        this.accuracy = accuracy;
        this.attack = attack;
        this.damage = damage;
        this.physicalDefense = physicalDefense;
        this.magicalDefense = magicalDefense;
    }
    
}

class Engineer/*They utilize advanced equipment (like jetpacks!), advanced modifiable ranged weapons,
        and different types of mech suits (piloted or autonomous) which they can repair and upgrade.*/
{
    Accuracy accuracy;
    Attack attack;
    Damage damage;
    PhysicalDefense physicalDefense;
    MagicalDefense magicalDefense;
    
    public Engineer(Accuracy accuracy, Attack attack, Damage damage, 
            PhysicalDefense physicalDefense, MagicalDefense magicalDefense)
    {
        this.accuracy = accuracy;
        this.attack = attack;
        this.damage = damage;
        this.physicalDefense = physicalDefense;
        this.magicalDefense = magicalDefense;
    }
}

class Healer//Healers keep their comrades battle ready and can revive them (they cannot heal Engineer's mech suits).
{
    Accuracy accuracy;
    Attack attack;
    Damage damage;
    PhysicalDefense physicalDefense;
    MagicalDefense magicalDefense;
    
    public Healer(Accuracy accuracy, Attack attack, Damage damage, 
            PhysicalDefense physicalDefense, MagicalDefense magicalDefense)
    {
        this.accuracy = accuracy;
        this.attack = attack;
        this.damage = damage;
        this.physicalDefense = physicalDefense;
        this.magicalDefense = magicalDefense;
    }
}

class MartialArtist//They are not afraid to punch or kick anything- they are the definition of super human strength.
{
    Accuracy accuracy;
    Attack attack;
    Damage damage;
    PhysicalDefense physicalDefense;
    MagicalDefense magicalDefense;
    
    public MartialArtist(Accuracy accuracy, Attack attack, Damage damage, 
            PhysicalDefense physicalDefense, MagicalDefense magicalDefense)
    {
        this.accuracy = accuracy;
        this.attack = attack;
        this.damage = damage;
        this.physicalDefense = physicalDefense;
        this.magicalDefense = magicalDefense;
    }
}

class Necromancer//They often engage in battle alone, because they use undead minions -tiny, small, big, and humongous- to do their bidding.
{
    Accuracy accuracy;
    Attack attack;
    Damage damage;
    PhysicalDefense physicalDefense;
    MagicalDefense magicalDefense;
    
    public Necromancer(Accuracy accuracy, Attack attack, Damage damage, 
            PhysicalDefense physicalDefense, MagicalDefense magicalDefense)
    {
        this.accuracy = accuracy;
        this.attack = attack;
        this.damage = damage;
        this.physicalDefense = physicalDefense;
        this.magicalDefense = magicalDefense;
    }
}

class Wizard/*They can manipulate the natural elements, confuse their opponents,  fly, and, if powerful enough,
        seal their opponents in another dimension for quite a while.*/
{
    Accuracy accuracy;
    Attack attack;
    Damage damage;
    PhysicalDefense physicalDefense;
    MagicalDefense magicalDefense;
    
    public Wizard(Accuracy accuracy, Attack attack, Damage damage, 
            PhysicalDefense physicalDefense, MagicalDefense magicalDefense)
    {
        this.accuracy = accuracy;
        this.attack = attack;
        this.damage = damage;
        this.physicalDefense = physicalDefense;
        this.magicalDefense = magicalDefense;
    }
}


class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        /*getAccuracy wizardAccuracy = new getAccuracy();
        getAttack wizardAttack = new getAttack();
        int wizardAccuracyValue = wizardAccuracy.accuracyStat(5);
        getAttack rg = wizardAttack.rollForAttack(2, wizardAccuracyValue);
        System.out.println(wizardAttack.rollForAttack(2, wizardAccuracyValue));
        */
        
        /*Linked list that holds characters that have been created and/or characters that have been loaded from a save file.
        And the strings are what hold the user-entered character names of their created characters.*/
        LinkedList loadedCharacters = new LinkedList();
        String AssassinFirstName;
        String AssassinLastName;
        
        int userMainMenu;
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Character Manager");
        System.out.println("-----------------------");
        //the character being shown as selected or not depends on something with the linked list for loadedCharacters? conditional?
        System.out.print("You have no character selected. Enter 1 to create a"+
                " new character, 2 to select an existing character, \n"+
                "3 to load a character from file, 4 to save a character to file,"+
                "5 to perform an action, or 6 to exit: ");
        userMainMenu = scan.nextInt();
        System.out.println();
        System.out.println();
        
        while(userMainMenu != 6)
        {
            //input validation for userMainMenu
            while(userMainMenu <=0 || userMainMenu >= 7)
            {
                System.out.println("Character Manager");
                System.out.println("-----------------------");
                System.out.print("Do not enter a number lower than 1 or higher"+
                " than 7. You have no character selected. Enter 1 to \n"+
                "create a new character, 2 to select an existing character, 3"+
                " to load a character from file, 4 to \nsave a character to"+
                " file, 5 to perform an action, or 6 to exit: ");
                userMainMenu = scan.nextInt();
                System.out.println();
                System.out.println();
            }
            
            if(userMainMenu == 1)
            {   
                
                System.out.println("Character Creation");
                System.out.println("-----------------------");
                System.out.print("Enter 0 to preview all classes, 1 to create"+
                " an Assassin, 2 for an Engineer, 3 for a Healer,\n4 for a"+
                " Martial Artist, 5 for a Necromancer, 6 for a Wizard, or 7 to quit: ");
                int characterCreationMenu;
                characterCreationMenu = scan.nextInt();
                System.out.println();
                System.out.println();
                while(characterCreationMenu != 7)
                {
                    //input validaiton for characterCreationMenu
                    while(characterCreationMenu <0 || characterCreationMenu >=8)
                    {
                        System.out.println("Character Creation");
                        System.out.println("-----------------------");
                        System.out.print("Enter 0 to preview all classes, 1 to create"+
                        " an Assassin, 2 for an Engineer, 3 for a Healer,\n4 for a"+
                        " Martial Artist, 5 for a Necromancer, 6 for a Wizard, or 7 to quit: ");
                        characterCreationMenu = scan.nextInt();
                        System.out.println();
                        System.out.println();
                    }
                
                    if(characterCreationMenu == 0)
                    {
                        System.out.println("Class Descriptions");
                        System.out.println("-----------------------");
                    
                        System.out.println("Assassin: The stealthy class. They"+
                        " utilize daggers, swords, poison darts, & silenced"+
                        " ranged weapons.");
                            
                        System.out.println();
                        
                        System.out.println("Engineer: They utilize advanced"+
                        " equipment (like jetpacks!), advanced ranged weapons,"+
                        " and different\ntypes of mech suits"+
                        " (piloted or autonomous) which they can repair and upgrade.");
                        
                        System.out.println();
                        
                        System.out.println("Healer: Healers keep their comrades"+
                        " battle ready and can revive them (they cannot heal"+
                        " Engineer's\nmech suits).");
                        
                        System.out.println();
                        
                        System.out.println("Martial Artist: They are not afraid"+
                        " to punch or kick anything- they are the definition"+
                        " of super\nhuman strength.");
                        
                        System.out.println();
                        
                        System.out.println("Necromancers: They often engage in"+
                        " battle alone, because they use undead minions -tiny,"+
                        " small,\nbig, and humongous- to do their bidding.");
                        
                        System.out.println();
                        
                        System.out.println("Wizard: They can manipulate the"+
                        " natural elements, confuse their opponents, fly, and,"+
                        " if\npowerful enough, seal their opponents in another"+
                        " dimension for quite a while.");
                        
                        System.out.println();
                        
                        System.out.print("When ready, press enter to continue");
                        try{System.in.read();}
                        catch(Exception e){}
                        System.out.println();
                        System.out.println();
                       
                    }
                    
                    //Assassin Class Creation
                    else if(characterCreationMenu == 1)
                    {
                        
                        File rangeText = new File("src/range.txt");
                        Scanner scan2 = new Scanner(rangeText);
                        int rangeInt1 = scan2.nextInt();//1
                        int rangeInt2 = scan2.nextInt();//250
                        Random generator = new Random();
                    
                        int randomNum1;
                        int randomNum2;
                        int randomNum3;
                        int randomNum4;
                        int randomNum5;
                        
                        /*random # between 1-250*/
                        randomNum1 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-250*/
                        randomNum2 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-250*/
                        randomNum3 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-250*/
                        randomNum4 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-250*/
                        randomNum5 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*the above random num values are later stored in these 
                        variables so that the user can select from randomly 
                        generated stat values for each stat*/
                        int randomAccuracyStat;
                        int randomAttackStat;
                        int randomDamageStat;
                        int randomPhyDefStat;
                        int randomMagDefStat;
                        
                        /*stores the randomNumbers that are used for the
                        assassin's stats so that more than one random number is
                        not applied to more than one stat*/
                        ArrayList<Integer> randomNumTaken = new ArrayList();
                        
                        System.out.println("Assassin Class Build");
                        System.out.println("-----------------------");
                        System.out.println("Character stats: Accuracy, Attack, Damage, Physical Defense, and Magical Defense");
                        System.out.println();
                        System.out.println("Random numbers to use for your stats: A."+randomNum1+"  B."+randomNum2+"  C."+randomNum3+"  D."+randomNum4+"  E."+randomNum5);
                        System.out.println();
                        System.out.println("Select a letter from above to add"+
                        " its numeric value to the stat you want it added\nto."+
                        " You can't use the same letter/value more than once.");
                        System.out.println();
                        System.out.println("Example: Enter your Accuracy stat: C (this would make your Accuracy Stat equal to "+randomNum3+")");
                        System.out.println();
                        System.out.print("Enter your Accuracy stat: ");
                        String accuracyStatChoice;
                        accuracyStatChoice = scan.next();
                        System.out.println();
                       
                        //Accuracy Stat if statements for Assassin class
                        if(accuracyStatChoice.equals("a") || accuracyStatChoice.equals("A"))
                        {
                            randomAccuracyStat = randomNum1;
                            try
                            {
                                FileWriter writeStats = new FileWriter("src/AssassinAccuracyStat.txt");
                                writeStats.write(String.valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum1);
                            
                        }
                        else if(accuracyStatChoice.equals("b") || accuracyStatChoice.equals("B"))
                        {
                            randomAccuracyStat = randomNum2;
                            try
                            {
                                FileWriter writeStats = new FileWriter("src/AssassinAccuracyStat.txt");
                                writeStats.write(String.valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum2);
                        }
                        else if(accuracyStatChoice.equals("c") || accuracyStatChoice.equals("C"))
                        {
                            randomAccuracyStat = randomNum3;
                            try
                            {
                                FileWriter writeStats = new FileWriter("src/AssassinAccuracyStat.txt");
                                writeStats.write(String.valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum3);
                        }
                        else if(accuracyStatChoice.equals("d") || accuracyStatChoice.equals("D"))
                        {
                            randomAccuracyStat = randomNum4;
                            try
                            {
                                FileWriter writeStats = new FileWriter("src/AssassinAccuracyStat.txt");
                                writeStats.write(String.valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum4);
                        }
                        else if(accuracyStatChoice.equals("e") || accuracyStatChoice.equals("E"))
                        {
                            randomAccuracyStat = randomNum5;
                            try
                            {
                                FileWriter writeStats = new FileWriter("src/AssassinAccuracyStat.txt");
                                writeStats.write(String.valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum5);
                        }
                        
                        System.out.print("Enter your Attack Stat: ");
                        String attackStatChoice;
                        attackStatChoice = scan.next();
                        System.out.println();
                        
                        //Attack Stat if statements for Assassin Class
                        if(attackStatChoice.equals("a") || attackStatChoice.equals("A"))
                        {
                            
                            if(randomNumTaken.contains(randomNum1))
                            {
                                System.out.print("This value is taken. You"+
                                " will have to start over your character"+
                                " creation. You\ncan't use the same letter/"+
                                "value more than once. Press enter to continue.");
                                try{System.in.read();}
                                catch(Exception e){}
                                System.out.println();
                                System.out.println();
                                break;
                            }
                            else
                            {
                                randomNumTaken.add(randomNum1);
                                randomAttackStat = randomNum1;
                                try
                                {
                                    FileWriter writeStats = new FileWriter("src/AssassinAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("b") || attackStatChoice.equals("B"))
                        {
                            if(randomNumTaken.contains(randomNum2))
                            {
                                System.out.print("This value is taken. You"+
                                " will have to start over your character"+
                                " creation. You\ncan't use the same letter/"+
                                "value more than once. Press enter to continue.");
                                try{System.in.read();}
                                catch(Exception e){}
                                System.out.println();
                                System.out.println();
                                break;
                            }
                            else
                            {
                                randomNumTaken.add(randomNum2);
                                randomAttackStat = randomNum2;
                                try
                                {
                                    FileWriter writeStats = new FileWriter("src/AssassinAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));/*writing a newline characters first so its
                                    easier to read from the AssassinStats files later*/
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("c") || attackStatChoice.equals("C"))
                        {
                            if(randomNumTaken.contains(randomNum3))
                            {
                                System.out.print("This value is taken. You"+
                                " will have to start over your character"+
                                " creation. You\ncan't use the same letter/"+
                                "value more than once. Press enter to continue.");
                                try{System.in.read();}
                                catch(Exception e){}
                                System.out.println();
                                System.out.println();
                                break;
                            }
                            else
                            {
                                randomNumTaken.add(randomNum3);
                                randomAttackStat = randomNum3;
                                try
                                {
                                    FileWriter writeStats = new FileWriter("src/AssassinAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));/*writing a newline characters first so its
                                    easier to read from the AssassinStats files later*/
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("d") || attackStatChoice.equals("D"))
                        {
                            if(randomNumTaken.contains(randomNum4))
                            {
                                System.out.print("This value is taken. You"+
                                " will have to start over your character"+
                                " creation. You\ncan't use the same letter/"+
                                "value more than once. Press enter to continue.");
                                try{System.in.read();}
                                catch(Exception e){}
                                System.out.println();
                                System.out.println();
                                break;
                            }
                            else
                            {
                                randomNumTaken.add(randomNum4);
                                randomAttackStat = randomNum4;
                                try
                                {
                                    FileWriter writeStats = new FileWriter("src/AssassinAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));/*writing a newline characters first so its
                                    easier to read from the AssassinStats files later*/
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("e") || attackStatChoice.equals("E"))
                        {
                            if(randomNumTaken.contains(randomNum5))
                            {
                                System.out.print("This value is taken. You"+
                                " will have to start over your character"+
                                " creation. You\ncan't use the same letter/"+
                                "value more than once. Press enter to continue.");
                                try{System.in.read();}
                                catch(Exception e){}
                                System.out.println();
                                System.out.println();
                                break;
                            }
                            else
                            {
                                randomNumTaken.add(randomNum5);
                                randomAttackStat = randomNum5;
                                try
                                {
                                    FileWriter writeStats = new FileWriter("src/AssassinAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));/*writing a newline characters first so its
                                    easier to read from the AssassinStats files later*/
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        
                        System.out.print("Enter your Damage Stat: ");
                        String damageStatChoice;
                        damageStatChoice = scan.next();
                        System.out.println();
                        
                        //Damage Stat if statements for Assassin Class
                        if(damageStatChoice.equals("a") || damageStatChoice.equals("A"))
                        {
                            
                            if(randomNumTaken.contains(randomNum1))
                            {
                                System.out.print("This value is taken. You"+
                                " will have to start over your character"+
                                " creation. You\ncan't use the same letter/"+
                                "value more than once. Press enter to continue.");
                                try{System.in.read();}
                                catch(Exception e){}
                                System.out.println();
                                System.out.println();
                                break;
                            }
                            else
                            {
                                randomNumTaken.add(randomNum1);
                                randomDamageStat = randomNum1;
                                try
                                {
                                    FileWriter writeStats = new FileWriter("src/AssassinDamageStat.txt");
                                    writeStats.write(String.valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("b") || damageStatChoice.equals("B"))
                        {
                            
                            if(randomNumTaken.contains(randomNum2))
                            {
                                System.out.print("This value is taken. You"+
                                " will have to start over your character"+
                                " creation. You\ncan't use the same letter/"+
                                "value more than once. Press enter to continue.");
                                try{System.in.read();}
                                catch(Exception e){}
                                System.out.println();
                                System.out.println();
                                break;
                            }
                            else
                            {
                                randomNumTaken.add(randomNum2);
                                randomDamageStat = randomNum2;
                                try
                                {
                                    FileWriter writeStats = new FileWriter("src/AssassinDamageStat.txt");
                                    writeStats.write(String.valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("c") || damageStatChoice.equals("C"))
                        {
                            
                            if(randomNumTaken.contains(randomNum3))
                            {
                                System.out.print("This value is taken. You"+
                                " will have to start over your character"+
                                " creation. You\ncan't use the same letter/"+
                                "value more than once. Press enter to continue.");
                                try{System.in.read();}
                                catch(Exception e){}
                                System.out.println();
                                System.out.println();
                                break;
                            }
                            else
                            {
                                randomNumTaken.add(randomNum3);
                                randomDamageStat = randomNum3;
                                try
                                {
                                    FileWriter writeStats = new FileWriter("src/AssassinDamageStat.txt");
                                    writeStats.write(String.valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("d") || damageStatChoice.equals("D"))
                        {
                            
                            if(randomNumTaken.contains(randomNum4))
                            {
                                System.out.print("This value is taken. You"+
                                " will have to start over your character"+
                                " creation. You\ncan't use the same letter/"+
                                "value more than once. Press enter to continue.");
                                try{System.in.read();}
                                catch(Exception e){}
                                System.out.println();
                                System.out.println();
                                break;
                            }
                            else
                            {
                                randomNumTaken.add(randomNum4);
                                randomDamageStat = randomNum4;
                                try
                                {
                                    FileWriter writeStats = new FileWriter("src/AssassinDamageStat.txt");
                                    writeStats.write(String.valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("e") || damageStatChoice.equals("E"))
                        {
                            
                            if(randomNumTaken.contains(randomNum5))
                            {
                                System.out.print("This value is taken. You"+
                                " will have to start over your character"+
                                " creation. You\ncan't use the same letter/"+
                                "value more than once. Press enter to continue.");
                                try{System.in.read();}
                                catch(Exception e){}
                                System.out.println();
                                System.out.println();
                                break;
                            }
                            else
                            {
                                randomNumTaken.add(randomNum5);
                                randomDamageStat = randomNum5;
                                try
                                {
                                    FileWriter writeStats = new FileWriter("src/AssassinDamageStat.txt");
                                    writeStats.write(String.valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        
                        System.out.print("Enter your Physical Defense Stat: ");
                        String phyDefStatChoice;
                        phyDefStatChoice = scan.next();
                        System.out.println();
                        
                        //Physical Defence Stat if statements for Assassin Class
                        if(phyDefStatChoice.equals("a") || phyDefStatChoice.equals("A"))
                        {
                            
                            if(randomNumTaken.contains(randomNum1))
                            {
                                System.out.print("This value is taken. You"+
                                " will have to start over your character"+
                                " creation. You\ncan't use the same letter/"+
                                "value more than once. Press enter to continue.");
                                try{System.in.read();}
                                catch(Exception e){}
                                System.out.println();
                                System.out.println();
                                break;
                            }
                            else
                            {
                                randomNumTaken.add(randomNum1);
                                randomPhyDefStat = randomNum1;
                                try
                                {
                                    FileWriter writeStats = new FileWriter("src/AssassinPhyDefStat.txt");
                                    writeStats.write(String.valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("b") || phyDefStatChoice.equals("B"))
                        {
                            
                            if(randomNumTaken.contains(randomNum2))
                            {
                                System.out.print("This value is taken. You"+
                                " will have to start over your character"+
                                " creation. You\ncan't use the same letter/"+
                                "value more than once. Press enter to continue.");
                                try{System.in.read();}
                                catch(Exception e){}
                                System.out.println();
                                System.out.println();
                                break;
                            }
                            else
                            {
                                randomNumTaken.add(randomNum2);
                                randomPhyDefStat = randomNum2;
                                try
                                {
                                    FileWriter writeStats = new FileWriter("src/AssassinPhyDefStat.txt");
                                    writeStats.write(String.valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("c") || phyDefStatChoice.equals("C"))
                        {
                            
                            if(randomNumTaken.contains(randomNum3))
                            {
                                System.out.print("This value is taken. You"+
                                " will have to start over your character"+
                                " creation. You\ncan't use the same letter/"+
                                "value more than once. Press enter to continue.");
                                try{System.in.read();}
                                catch(Exception e){}
                                System.out.println();
                                System.out.println();
                                break;
                            }
                            else
                            {
                                randomNumTaken.add(randomNum3);
                                randomPhyDefStat = randomNum3;
                                try
                                {
                                    FileWriter writeStats = new FileWriter("src/AssassinPhyDefStat.txt");
                                    writeStats.write(String.valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("d") || phyDefStatChoice.equals("D"))
                        {
                            
                            if(randomNumTaken.contains(randomNum4))
                            {
                                System.out.print("This value is taken. You"+
                                " will have to start over your character"+
                                " creation. You\ncan't use the same letter/"+
                                "value more than once. Press enter to continue.");
                                try{System.in.read();}
                                catch(Exception e){}
                                System.out.println();
                                System.out.println();
                                break;
                            }
                            else
                            {
                                randomNumTaken.add(randomNum4);
                                randomPhyDefStat = randomNum4;
                                try
                                {
                                    FileWriter writeStats = new FileWriter("src/AssassinPhyDefStat.txt");
                                    writeStats.write(String.valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("e") || phyDefStatChoice.equals("E"))
                        {
                            
                            if(randomNumTaken.contains(randomNum5))
                            {
                                System.out.print("This value is taken. You"+
                                " will have to start over your character"+
                                " creation. You\ncan't use the same letter/"+
                                "value more than once. Press enter to continue.");
                                try{System.in.read();}
                                catch(Exception e){}
                                System.out.println();
                                System.out.println();
                                break;
                            }
                            else
                            {
                                randomNumTaken.add(randomNum5);
                                randomPhyDefStat = randomNum5;
                                try
                                {
                                    FileWriter writeStats = new FileWriter("src/AssassinPhyDefStat.txt");
                                    writeStats.write(String.valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        
                        System.out.print("Enter your Magical Defense Stat: ");
                        String magDefStatChoice;
                        magDefStatChoice = scan.next();
                        System.out.println();
                        
                        //Magical Defense Stat if statements for Assassin Class
                        if(magDefStatChoice.equals("a") || magDefStatChoice.equals("A"))
                        {
                            
                            if(randomNumTaken.contains(randomNum1))
                            {
                                System.out.print("This value is taken. You"+
                                " will have to start over your character"+
                                " creation. You\ncan't use the same letter/"+
                                "value more than once. Press enter to continue.");
                                try{System.in.read();}
                                catch(Exception e){}
                                System.out.println();
                                System.out.println();
                                break;
                            }
                            else
                            {
                                randomNumTaken.add(randomNum1);
                                randomMagDefStat = randomNum1;
                                try
                                {
                                    FileWriter writeStats = new FileWriter("src/AssassinMagDefStat.txt");
                                    writeStats.write(String.valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("b") || magDefStatChoice.equals("B"))
                        {
                            
                            if(randomNumTaken.contains(randomNum2))
                            {
                                System.out.print("This value is taken. You"+
                                " will have to start over your character"+
                                " creation. You\ncan't use the same letter/"+
                                "value more than once. Press enter to continue.");
                                try{System.in.read();}
                                catch(Exception e){}
                                System.out.println();
                                System.out.println();
                                break;
                            }
                            else
                            {
                                randomNumTaken.add(randomNum2);
                                randomMagDefStat = randomNum2;
                                try
                                {
                                    FileWriter writeStats = new FileWriter("src/AssassinMagDefStat.txt");
                                    writeStats.write(String.valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("c") || magDefStatChoice.equals("C"))
                        {
                            
                            if(randomNumTaken.contains(randomNum3))
                            {
                                System.out.print("This value is taken. You"+
                                " will have to start over your character"+
                                " creation. You\ncan't use the same letter/"+
                                "value more than once. Press enter to continue.");
                                try{System.in.read();}
                                catch(Exception e){}
                                System.out.println();
                                System.out.println();
                                break;
                            }
                            else
                            {
                                randomNumTaken.add(randomNum3);
                                randomMagDefStat = randomNum3;
                                try
                                {
                                    FileWriter writeStats = new FileWriter("src/AssassinMagDefStat.txt");
                                    writeStats.write(String.valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("d") || magDefStatChoice.equals("D"))
                        {
                            
                            if(randomNumTaken.contains(randomNum4))
                            {
                                System.out.print("This value is taken. You"+
                                " will have to start over your character"+
                                " creation. You\ncan't use the same letter/"+
                                "value more than once. Press enter to continue.");
                                try{System.in.read();}
                                catch(Exception e){}
                                System.out.println();
                                System.out.println();
                                break;
                            }
                            else
                            {
                                randomNumTaken.add(randomNum4);
                                randomMagDefStat = randomNum4;
                                try
                                {
                                    FileWriter writeStats = new FileWriter("src/AssassinMagDefStat.txt");
                                    writeStats.write(String.valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("e") || magDefStatChoice.equals("E"))
                        {
                            
                            if(randomNumTaken.contains(randomNum5))
                            {
                                System.out.print("This value is taken. You"+
                                " will have to start over your character"+
                                " creation. You\ncan't use the same letter/"+
                                "value more than once. Press enter to continue.");
                                try{System.in.read();}
                                catch(Exception e){}
                                System.out.println();
                                System.out.println();
                                break;
                            }
                            else
                            {
                                randomNumTaken.add(randomNum5);
                                randomMagDefStat = randomNum5;
                                try
                                {
                                    FileWriter writeStats = new FileWriter("src/AssassinMagDefStat.txt");
                                    writeStats.write(String.valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        
                        
                        System.out.print("Enter the first name of your Assassin character: ");
                        AssassinFirstName = scan.next();//AssassinFirstName is "global"
                        
                        /*add character name variable "AssassinFirstName" to
                        loadedCharacters linked list to be accessed in other 
                        parts of the program (like selecting an existing 
                        character)*/
                        loadedCharacters.add(AssassinFirstName);/*linked list "loaded
                        characters" is "global"*/
                        
                        try//write AssassinFirstName to AssassinFirstName.txt file
                        {
                            /*AssassinName and AssassinName.txt can only
                            store one Assassin character name, so the newly
                            created character's name must be written to this txt
                            file which will later be read so that said character
                            name can be written to another file(which the user
                            will name and said txt file will also contain all of
                            the Assassin Character's stats) after being created,
                            otherwise upon creating another Assassin character,
                            the previously created one will be overwritten by
                            the newer one.*/
                            FileWriter writeStats = new FileWriter("src/AssassinFirstName.txt");
                            writeStats.write(String.valueOf(AssassinFirstName));
                            writeStats.close();
                            
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //-----------------------------------------------------
                        /*do the same thing like above, but with the Assassin's 
                        last name*/
                        
                        System.out.print("Enter the last name of your Assassin character: ");
                        AssassinLastName = scan.next();//AssassinFirstName is "global"
                        
                        /*add character name variable "AssassinLastName" to
                        loadedCharacters linked list to be accessed in other 
                        parts of the program (like selecting an existing 
                        character)*/
                        loadedCharacters.add(AssassinLastName);/*linked list "loaded
                        characters" is "global"*/
                        
                        try//write AssassinLastName to AssassinLastName.txt file
                        {
                            /*AssassinFirstName and AssassinName.txt can only
                            store one Assassin character name, so the newly
                            created character's name must be written to this txt
                            file which will later be read so that said character
                            name can be written to another file(which the user
                            will name and said txt file will also contain all of
                            the Assassin Character's stats) after being created,
                            otherwise upon creating another Assassin character,
                            the previously created one will be overwritten by
                            the newer one.*/
                            FileWriter writeStats = new FileWriter("src/AssassinLastName.txt");
                            writeStats.write(String.valueOf(AssassinLastName));
                            writeStats.close();
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        System.out.println();
                        System.out.print("WARNING: Be sure to save your"+
                        " character after this so that you can load them back"+
                        "\nup later, otherwise you risk overwriting your"+
                        " character and losing all of their\ndata. Press enter"+
                        " to continue.");
                        try{System.in.read();}
                        catch(Exception e){}
                        System.out.println();
                        System.out.println();
                    }
                    System.out.println("Character Creation");
                    System.out.println("-----------------------");
                    System.out.print("Enter 0 to preview all classes, 1 to create"+
                    " an Assassin, 2 for an Engineer, 3 for a Healer,\n4 for a"+
                    " Martial Artist, 5 for a Necromancer, 6 for a Wizard, or 7 to quit: ");
                    characterCreationMenu = scan.nextInt();
                    System.out.println();
                    System.out.println();
                }      
            }
            else if(userMainMenu == 2)
            {
                System.out.println("TEST!");
                System.out.println();
                System.out.println();
                
            }
           
            System.out.println("Character Manager");
            System.out.println("-----------------------");
            System.out.print("You have no character selected. Enter 1 to create a"+
                " new character, 2 to select an existing character, \n"+
                "3 to load a character from file, 4 to save a character to file,"+
                "5 to perform an action, or 6 to exit: ");
            userMainMenu = scan.nextInt();
            System.out.println();
            System.out.println();
        }
    }
}


