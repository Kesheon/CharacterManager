
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
    public int accuracyStat(int randomAccuracyStat);/*the randomAccuracyStat
    value will be the random number that the user selects for their accuracy
    stat during character creation*/
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
    public int rollForAttack(int randomNum1, int randomAccuracyStat);/*
    randomAccuracyStat is the random number that the user selects for their
    accuracy stat during character creation*/
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
    public int rollForDamage(int randomNum2, int randomAttackStat);/*
    randomAttackStat is the random number that the user selects for their attack
    stat during character creation*/
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
    public int rollForPhyDef(int randomNum3, int randomPhyDefStat);/*
    phyDefStat is the random number that the user selects for their physical
    defense stat during character creation*/
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

class Assassin/*The stealthy class. They utilize daggers, swords, poison darts,
        & silenced ranged weapons*/
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

class Engineer/*They utilize advanced equipment (like jetpacks!), advanced
        modifiable ranged weapons, and different types of mech suits (piloted or
        autonomous) which they can repair and upgrade.*/
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

class Healer/*Healers keep their comrades battle ready and can revive them
        (they cannot heal Engineer's mech suits).*/
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

class MartialArtist/*They are not afraid to punch or kick anything- they are the
        definition of super human strength.*/
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

class Necromancer/*They often engage in battle alone, because they use undead
        minions -tiny, small, big, and humongous- to do their bidding. They can 
        take the life force from the living to heal themselves.*/
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

class Wizard/*They can manipulate the natural elements of the earth and beyond,
        confuse their opponents, and, if powerful enough,
        seal their opponents in another dimension.*/
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
        
        /*Linked list that holds characters that are newly created. This list
        does not need to store loaded characters that are loaded from a user
        save file, because the selectedCharacter list does that. The 
        selectedCharacter list is also able to add characters to it that are
        currently existing characters (whether said characters have a save file
        or not). The selectedCharacter list only holds one character at a time
        (since only one character at a time can be loaded/ be the currently
        selected character).*/
        LinkedList loadedCharacters = new LinkedList();
        String AssassinFirstName;
        String AssassinLastName;
        
        /*The strings are what hold the user-entered character names of
        their created characters or characters loaded from a save file.*/
        String EngineerFirstName;
        String EngineerLastName;
        
        String HealerFirstName;
        String HealerLastName;
        
        String MartialArtistFirstName;
        String MartialArtistLastName;
        
        String NecromancerFirstName;
        String NecromancerLastName;
        
        String WizardFirstName;
        String WizardLastName;
        
        /*this list holds characters that are currently selected. Currently
        selected 
        characters are also present in the loadedCharacters list (only if they
        were created during the programs runtime), but the difference between a
        character in the loadedCharacters list (that is not currently selected)
        and a selected one is that a selected character can actually be used by
        the user since it is the current character in use, while the other
        character in the loadedCharacters list is just in temporary saved
        files/memory.*/
        LinkedList selectedCharacter = new LinkedList();
        
        /*this list will hold only 1 int value at a time. The value of said int
        will be used to determine the class of a created character, a selected
        existing character, or a loaded character so that the correct class can
        be used for the correct character.  */
        ArrayList<Integer> selectedCharacterClass = new ArrayList();
        
        //these values are added to the above array for the above mentioned reason
        int thisIsAssassin = 1;
        int thisIsEngineer = 2;
        int thisIsHealer = 3;
        int thisIsMartialArtist = 4;
        int thisIsNecromancer = 5;
        int thisIsWizard = 6;
        
        //this variable is used to create the user's custom-name save file
        String userNamedSaveFile;
        
        //----------------------------------------------------------------------
        //Program starts below, everything above is used later in the program
        
        int userMainMenu;
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Character Manager");
        System.out.println("-----------------------");
        System.out.print("You have no character selected. Enter 1 to create a"+
                " new character, 2 to select an existing character, \n"+
                "3 to load a character from file, 4 to save a character to file,"+
                " 5 to perform an action, or 6 to exit: ");
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
                        " Martial Artist, 5 for a Necromancer, 6"+
                        " for a Wizard, or 7 to quit: ");
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
                        " small,\nbig, and humongous- to do their bidding. They"+
                        " can take the life force from the living to heal\nthemselves.");
                        
                        System.out.println();
                        
                        System.out.println("Wizard: They can manipulate the"+
                        " natural elements of the earth and beyond, confuse"+
                        " their\nopponents, and, if powerful enough, seal their"+
                        " opponents in another dimension.");
                        
                        System.out.println();
                        
                        System.out.print("When ready, press enter to continue.");
                        try{System.in.read();}
                        catch(Exception e){}
                        System.out.println();
                        System.out.println();
                       
                    }
                    
                    //Assassin Class Creation
                    else if(characterCreationMenu == 1)
                    {
           
                        /*range.txt holds the numbers in the range of 1-1000 so
                        that it can be read from to provide random numbers in
                        said range so that in character creation the user can
                        pick 5 of said random numbers to be used for their 
                        5 stats (Accuracy, Attack, Damage, Physical Defense,
                        and Magical Defense).*/
                        File rangeText = new File("src/range.txt");
                        Scanner scanRange = new Scanner(rangeText);
                        int rangeInt1 = scanRange.nextInt();//1
                        int rangeInt2 = scanRange.nextInt();//1000
                        Random generator = new Random();
                    
                        int randomNum1;
                        int randomNum2;
                        int randomNum3;
                        int randomNum4;
                        int randomNum5;
                        
                        /*random # between 1-1000*/
                        randomNum1 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum2 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum3 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum4 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum5 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*the above random num values are later stored in these 
                        variables below so that the user can select from randomly 
                        generated stat values for each stat which will then be 
                        written to a txt file so that its value can be read/
                        loaded later on*/
                        /*these stat variables below are written to their txt files
                        as strings. Every stat variable in the program is either
                        read from a txt file or written to a txt file as a
                        string*/
                        int randomAccuracyStat;
                        int randomAttackStat;
                        int randomDamageStat;
                        int randomPhyDefStat;
                        int randomMagDefStat;
                        
                        /*stores the randomNumbers that are used for the
                        Assassin's stats so that more than one random number is
                        not applied to more than one stat*/
                        ArrayList<Integer> randomNumTaken = new ArrayList();
                        
                        System.out.println("Assassin Class Build");
                        System.out.println("-----------------------");
                        System.out.println("Character stats: Accuracy, Attack,"+
                        " Damage, Physical Defense, and Magical Defense");
                        System.out.println();
                        System.out.println("Random numbers to use for your"+
                        " stats: A."+randomNum1+"  B."+randomNum2+"  C"+
                        "."+randomNum3+"  D."+randomNum4+"  E."+randomNum5);
                        System.out.println();
                        System.out.println("Select a letter from above to add"+
                        " its numeric value to the stat you want it added\nto."+
                        " You can't use the same letter/value more than once.");
                        System.out.println();
                        System.out.println("Example: Enter your Accuracy stat:"+
                        " C (this would make your Accuracy Stat equal"+
                        " to "+randomNum3+")");
                        System.out.println();
                        System.out.print("Enter your Accuracy stat: ");
                        String accuracyStatChoice;
                        accuracyStatChoice = scan.next();
                        System.out.println();
                       
                        //Accuracy Stat if statements for Assassin class
                        if(accuracyStatChoice.equals("a") || 
                           accuracyStatChoice.equals("A"))
                        {
                            randomAccuracyStat = randomNum1;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/AssassinAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum1);
                            
                        }
                        else if(accuracyStatChoice.equals("b") || 
                                accuracyStatChoice.equals("B"))
                        {
                            randomAccuracyStat = randomNum2;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/AssassinAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum2);
                        }
                        else if(accuracyStatChoice.equals("c") ||
                                accuracyStatChoice.equals("C"))
                        {
                            randomAccuracyStat = randomNum3;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/AssassinAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum3);
                        }
                        else if(accuracyStatChoice.equals("d") ||
                                accuracyStatChoice.equals("D"))
                        {
                            randomAccuracyStat = randomNum4;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/AssassinAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum4);
                        }
                        else if(accuracyStatChoice.equals("e") ||
                                accuracyStatChoice.equals("E"))
                        {
                            randomAccuracyStat = randomNum5;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/AssassinAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
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
                        if(attackStatChoice.equals("a") ||
                           attackStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/AssassinAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("b") ||
                                attackStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/AssassinAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("c") ||
                                attackStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/AssassinAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("d") ||
                                attackStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/AssassinAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("e") ||
                                attackStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/AssassinAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
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
                        if(damageStatChoice.equals("a") ||
                           damageStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/AssassinDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("b") ||
                                damageStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/AssassinDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("c") ||
                                damageStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/AssassinDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("d") ||
                                damageStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/AssassinDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("e") ||
                                damageStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/AssassinDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
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
                        if(phyDefStatChoice.equals("a") ||
                           phyDefStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/AssassinPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("b") ||
                                phyDefStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/AssassinPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("c") ||
                                phyDefStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/AssassinPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("d") ||
                                phyDefStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/AssassinPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("e") ||
                                phyDefStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/AssassinPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
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
                        if(magDefStatChoice.equals("a") ||
                           magDefStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/AssassinMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("b") ||
                                magDefStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/AssassinMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("c") ||
                                magDefStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/AssassinMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("d") ||
                                magDefStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/AssassinMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("e") ||
                                magDefStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/AssassinMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        
                        System.out.print("Enter the first name of your"+
                                " Assassin character: ");
                        AssassinFirstName = scan.next();//AssassinFirstName is "global"
                        
                        /*add character name variable "AssassinFirstName" to
                        loadedCharacters linked list to be accessed in other 
                        parts of the program (like selecting an existing 
                        character)*/
                        loadedCharacters.add(AssassinFirstName);/*linked list "loaded
                        characters" is "global"*/
                        
                        try//write AssassinFirstName to AssassinFirstName.txt file
                        {
                            /*AssassinFirstName and AssassinFirstName.txt can only
                            store one Assassin character's first name, so the newly
                            created character's first name must be written to this txt
                            file which will later be read so that said character
                            name can be written to another file(which the user
                            will name and said txt file will also contain all of
                            the Assassin Character's stats) after being created,
                            otherwise upon creating another Assassin character,
                            the previously created one will be overwritten by
                            the newer one.*/
                            FileWriter writeStats = new FileWriter
                            ("src/AssassinFirstName.txt");
                            writeStats.write(AssassinFirstName);
                            writeStats.close();
                            
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Assassin the currently selected character
                        /*if both lists are empty...add AssassinFirstName then
                        add thisIsAssassin (value 1)*/
                        if(selectedCharacter.isEmpty())
                        {
                            selectedCharacter.add(AssassinFirstName);
                            
                            if(selectedCharacterClass.isEmpty())
                            {
                                /*values that are added to the selectedCharacterClass
                                list are added after the first name of a character
                                is added to the selectedCharacter list.*/
                                selectedCharacterClass.add(thisIsAssassin);
                                
                            }
                            
                        }
                        /*If not empty then clear it to make way for the Assassin
                        Character to be the currently selected character. And
                        make way for the selectedCharacterClass to add the correct
                        value for the class that is being created.*/
                        else
                        {
                            selectedCharacter.clear();
                            selectedCharacter.add(AssassinFirstName);
                            selectedCharacterClass.clear();
                            selectedCharacterClass.add(thisIsAssassin);
                        }
                        
                        //-----------------------------------------------------
                        /*do the same thing like above, but with the Assassin's 
                        last name*/
                        
                        System.out.print("Enter the last name of your"+
                                " Assassin character: ");
                        AssassinLastName = scan.next();//AssassinLastName is "global"
                        
                        /*add character name variable "AssassinLastName" to
                        loadedCharacters linked list to be accessed in other 
                        parts of the program (like selecting an existing 
                        character)*/
                        loadedCharacters.add(AssassinLastName);/*linked list "loaded
                        characters" is "global"*/
                        
                        try//write AssassinLastName to AssassinLastName.txt file
                        {
                            /*AssassinLastName and AssassinLastName.txt can only
                            store one Assassin character's last name, so the newly
                            created character's name must be written to this txt
                            file which will later be read so that said character
                            name can be written to another file(which the user
                            will name and said txt file will also contain all of
                            the Assassin Character's stats) after being created,
                            otherwise upon creating another Assassin character,
                            the previously created one will be overwritten by
                            the newer one.*/
                            FileWriter writeStats = new FileWriter
                            ("src/AssassinLastName.txt");
                            writeStats.write(AssassinLastName);
                            writeStats.close();
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Assassin the currently selected character
                        /*if selectedCharacter contains AssassinFirstName...add
                        AssassinLastName*/
                        if(selectedCharacter.contains(AssassinFirstName))
                        {
                            selectedCharacter.add(AssassinLastName);
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
                    
                    //Engineer Class Creation
                    else if(characterCreationMenu == 2)
                    {
                        /*range.txt holds the numbers in the range of 1-1000 so
                        that it can be read from to provide random numbers in
                        said range so that in character creation the user can
                        pick 5 of said random numbers to be used for their 
                        5 stats (Accuracy, Attack, Damage, Physical Defense,
                        and Magical Defense).*/
                        File rangeText = new File("src/range.txt");
                        Scanner scanRange = new Scanner(rangeText);
                        int rangeInt1 = scanRange.nextInt();//1
                        int rangeInt2 = scanRange.nextInt();//1000
                        Random generator = new Random();
                    
                        int randomNum1;
                        int randomNum2;
                        int randomNum3;
                        int randomNum4;
                        int randomNum5;
                        
                        /*random # between 1-1000*/
                        randomNum1 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum2 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum3 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum4 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum5 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*the above random num values are later stored in these 
                        variables below so that the user can select from randomly 
                        generated stat values for each stat which will then be 
                        written to a txt file so that its value can be read/
                        loaded later on*/
                        /*these stat variables below are written to their txt files
                        as strings. Every stat variable in the program is either
                        read from a txt file or written to a txt file as a
                        string*/
                        int randomAccuracyStat;
                        int randomAttackStat;
                        int randomDamageStat;
                        int randomPhyDefStat;
                        int randomMagDefStat;
                        
                        /*stores the randomNumbers that are used for the
                        Engineer's stats so that more than one random number is
                        not applied to more than one stat*/
                        ArrayList<Integer> randomNumTaken = new ArrayList();
                        
                        System.out.println("Engineer Class Build");
                        System.out.println("-----------------------");
                        System.out.println("Character stats: Accuracy, Attack,"+
                        " Damage, Physical Defense, and Magical Defense");
                        System.out.println();
                        System.out.println("Random numbers to use for your"+
                        " stats: A."+randomNum1+"  B."+randomNum2+"  C"+
                        "."+randomNum3+"  D."+randomNum4+"  E."+randomNum5);
                        System.out.println();
                        System.out.println("Select a letter from above to add"+
                        " its numeric value to the stat you want it added\nto."+
                        " You can't use the same letter/value more than once.");
                        System.out.println();
                        System.out.println("Example: Enter your Accuracy"+
                        " stat: C (this would make your Accuracy Stat equal"+
                        " to "+randomNum3+")");
                        System.out.println();
                        System.out.print("Enter your Accuracy stat: ");
                        String accuracyStatChoice;
                        accuracyStatChoice = scan.next();
                        System.out.println();
                        
                        //Accuracy Stat if statements for Engineer class
                        if(accuracyStatChoice.equals("a") ||
                           accuracyStatChoice.equals("A"))
                        {
                            randomAccuracyStat = randomNum1;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/EngineerAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum1);
                            
                        }
                        else if(accuracyStatChoice.equals("b") ||
                                accuracyStatChoice.equals("B"))
                        {
                            randomAccuracyStat = randomNum2;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/EngineerAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum2);
                        }
                        else if(accuracyStatChoice.equals("c") ||
                                accuracyStatChoice.equals("C"))
                        {
                            randomAccuracyStat = randomNum3;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/EngineerAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum3);
                        }
                        else if(accuracyStatChoice.equals("d") ||
                                accuracyStatChoice.equals("D"))
                        {
                            randomAccuracyStat = randomNum4;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/EngineerAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum4);
                        }
                        else if(accuracyStatChoice.equals("e") ||
                                accuracyStatChoice.equals("E"))
                        {
                            randomAccuracyStat = randomNum5;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/EngineerAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
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
                        
                        //Attack Stat if statements for Engineer Class
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/EngineerAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("b") ||
                                attackStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/EngineerAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("c") ||
                                attackStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/EngineerAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("d") ||
                                attackStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/EngineerAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("e") ||
                                attackStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/EngineerAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
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
                        
                        //Damage Stat if statements for Engineer Class
                        if(damageStatChoice.equals("a") ||
                           damageStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/EngineerDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("b") ||
                                damageStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/EngineerDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("c") ||
                                damageStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/EngineerDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("d") ||
                                damageStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/EngineerDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("e") ||
                                damageStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/EngineerDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
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
                        
                        //Physical Defence Stat if statements for Engineer Class
                        if(phyDefStatChoice.equals("a") ||
                           phyDefStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/EngineerPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("b") ||
                                phyDefStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/EngineerPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("c") ||
                                phyDefStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/EngineerPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("d") ||
                                phyDefStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/EngineerPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("e") ||
                                phyDefStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/EngineerPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
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
                        
                        //Magical Defense Stat if statements for Engineer Class
                        if(magDefStatChoice.equals("a") ||
                           magDefStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/EngineerMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("b") ||
                                magDefStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/EngineerMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("c") ||
                                magDefStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/EngineerMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("d") ||
                                magDefStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/EngineerMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("e") ||
                                magDefStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/EngineerMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        System.out.print("Enter the first name of your"+
                                " Engineer character: ");
                        EngineerFirstName = scan.next();/*EngineerFirstName is
                        "global"*/
                        
                        /*add character name variable "EngineerFirstName" to
                        loadedCharacters linked list to be accessed in other 
                        parts of the program (like selecting an existing 
                        character)*/
                        loadedCharacters.add(EngineerFirstName);/*
                        linked list "loaded
                        characters" is "global"*/
                        
                        try//write EngineerFirstName to EngineerFirstName.txt file
                        {
                            /*EngineerFirstName and EngineerFirstName.txt can only
                            store one Engineer character's First name, so the newly
                            created character's first name must be written to this txt
                            file which will later be read so that said character
                            name can be written to another file(which the user
                            will name and said txt file will also contain all of
                            the Engineer Character's stats) after being created,
                            otherwise upon creating another Engineer character,
                            the previously created one will be overwritten by
                            the newer one.*/
                            FileWriter writeStats = new FileWriter
                            ("src/EngineerFirstName.txt");
                            writeStats.write(EngineerFirstName);
                            writeStats.close();
                            
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Engineer the currently selected character
                        /*if both lists are empty...add EngineerFirstName then
                        add thisIsEngineer (value 2)*/
                        if(selectedCharacter.isEmpty())
                        {
                            selectedCharacter.add(EngineerFirstName);
                            
                            if(selectedCharacterClass.isEmpty())
                            {
                                /*values that are added to the selectedCharacterClass
                                list are added after the first name of a character
                                is added to the selectedCharacter list.*/
                                selectedCharacterClass.add(thisIsEngineer);
                                
                            }
                            
                        }
                        /*If not empty then clear it to make way for the Engineer
                        Character to be the currently selected character. And
                        make way for the selectedCharacterClass to add the correct
                        value for the class that is being created.*/
                        else
                        {
                            selectedCharacter.clear();
                            selectedCharacter.add(EngineerFirstName);
                            selectedCharacterClass.clear();
                            selectedCharacterClass.add(thisIsEngineer);
                        }
                        
                        //-----------------------------------------------------
                        /*do the same thing like above, but with the Engineer's 
                        last name*/
                        
                        System.out.print("Enter the last name of your"+
                                " Engineer character: ");
                        EngineerLastName = scan.next();//EngineerLastName is "global"
                        
                        /*add character name variable "EngineerLastName" to
                        loadedCharacters linked list to be accessed in other 
                        parts of the program (like selecting an existing 
                        character)*/
                        loadedCharacters.add(EngineerLastName);/*linked list "loaded
                        characters" is "global"*/
                        
                        try//write EngineerLastName to EngineerLastName.txt file
                        {
                            /*EngineerLastName and EngineerLastName.txt can only
                            store one Engineer character's last name, so the newly
                            created character's name must be written to this txt
                            file which will later be read so that said character
                            name can be written to another file(which the user
                            will name and said txt file will also contain all of
                            the Engineer Character's stats) after being created,
                            otherwise upon creating another Engineer character,
                            the previously created one will be overwritten by
                            the newer one.*/
                            FileWriter writeStats = new FileWriter
                            ("src/EngineerLastName.txt");
                            writeStats.write(EngineerLastName);
                            writeStats.close();
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Engineer the currently selected character
                        /*if selectedCharacter contains EngineerFirstName...add
                        EngineerLastName*/
                        if(selectedCharacter.contains(EngineerFirstName))
                        {
                            selectedCharacter.add(EngineerLastName);
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
                    
                    //Healer Class Creation
                    else if(characterCreationMenu == 3)
                    {
                        /*range.txt holds the numbers in the range of 1-1000 so
                        that it can be read from to provide random numbers in
                        said range so that in character creation the user can
                        pick 5 of said random numbers to be used for their 
                        5 stats (Accuracy, Attack, Damage, Physical Defense,
                        and Magical Defense).*/
                        File rangeText = new File("src/range.txt");
                        Scanner scanRange = new Scanner(rangeText);
                        int rangeInt1 = scanRange.nextInt();//1
                        int rangeInt2 = scanRange.nextInt();//1000
                        Random generator = new Random();
                    
                        int randomNum1;
                        int randomNum2;
                        int randomNum3;
                        int randomNum4;
                        int randomNum5;
                        
                        /*random # between 1-1000*/
                        randomNum1 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum2 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum3 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum4 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum5 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*the above random num values are later stored in these 
                        variables below so that the user can select from randomly 
                        generated stat values for each stat which will then be 
                        written to a txt file so that its value can be read/
                        loaded later on*/
                        /*these stat variables below are written to their txt files
                        as strings. Every stat variable in the program is either
                        read from a txt file or written to a txt file as a
                        string*/
                        int randomAccuracyStat;
                        int randomAttackStat;
                        int randomDamageStat;
                        int randomPhyDefStat;
                        int randomMagDefStat;
                        
                        /*stores the randomNumbers that are used for the
                        Healer's stats so that more than one random number is
                        not applied to more than one stat*/
                        ArrayList<Integer> randomNumTaken = new ArrayList();
                        
                        System.out.println("Healer Class Build");
                        System.out.println("-----------------------");
                        System.out.println("Character stats: Accuracy, Attack,"+
                        " Damage, Physical Defense, and Magical Defense");
                        System.out.println();
                        System.out.println("Random numbers to use for your"+
                        " stats: A."+randomNum1+"  B."+randomNum2+"  C"+
                        "."+randomNum3+"  D."+randomNum4+"  E."+randomNum5);
                        System.out.println();
                        System.out.println("Select a letter from above to add"+
                        " its numeric value to the stat you want it added\nto."+
                        " You can't use the same letter/value more than once.");
                        System.out.println();
                        System.out.println("Example: Enter your Accuracy"+
                        " stat: C (this would make your Accuracy Stat equal"+
                        " to "+randomNum3+")");
                        System.out.println();
                        System.out.print("Enter your Accuracy stat: ");
                        String accuracyStatChoice;
                        accuracyStatChoice = scan.next();
                        System.out.println();
                        
                        //Accuracy Stat if statements for Healer class
                        if(accuracyStatChoice.equals("a") ||
                           accuracyStatChoice.equals("A"))
                        {
                            randomAccuracyStat = randomNum1;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/HealerAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum1);
                            
                        }
                        else if(accuracyStatChoice.equals("b") ||
                                accuracyStatChoice.equals("B"))
                        {
                            randomAccuracyStat = randomNum2;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/HealerAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum2);
                        }
                        else if(accuracyStatChoice.equals("c") ||
                                accuracyStatChoice.equals("C"))
                        {
                            randomAccuracyStat = randomNum3;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/HealerAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum3);
                        }
                        else if(accuracyStatChoice.equals("d") ||
                                accuracyStatChoice.equals("D"))
                        {
                            randomAccuracyStat = randomNum4;
                            try
                            {
                                FileWriter writeStats = 
                                        new FileWriter
                                        ("src/HealerAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum4);
                        }
                        else if(accuracyStatChoice.equals("e") ||
                                accuracyStatChoice.equals("E"))
                        {
                            randomAccuracyStat = randomNum5;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/HealerAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
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
                        
                        //Attack Stat if statements for Healer Class
                        if(attackStatChoice.equals("a") ||
                           attackStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/HealerAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("b") ||
                                attackStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/HealerAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("c") ||
                                attackStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/HealerAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("d") ||
                                attackStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/HealerAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("e") ||
                                attackStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/HealerAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
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
                        
                        //Damage Stat if statements for Healer Class
                        if(damageStatChoice.equals("a") ||
                           damageStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/HealerDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("b") ||
                                damageStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/HealerDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("c") ||
                                damageStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/HealerDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("d") ||
                                damageStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/HealerDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("e") ||
                                damageStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/HealerDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
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
                        
                        //Physical Defence Stat if statements for Healer Class
                        if(phyDefStatChoice.equals("a") ||
                           phyDefStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/HealerPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("b") ||
                                phyDefStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/HealerPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("c") ||
                                phyDefStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/HealerPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("d") ||
                                phyDefStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/HealerPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("e") ||
                                phyDefStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/HealerPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
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
                        
                        //Magical Defense Stat if statements for Healer Class
                        if(magDefStatChoice.equals("a") ||
                           magDefStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/HealerMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("b") ||
                                magDefStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/HealerMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("c") ||
                                magDefStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/HealerMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("d") ||
                                magDefStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/HealerMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("e") ||
                                magDefStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/HealerMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        
                        System.out.print("Enter the first name of your Healer"+
                        " character: ");
                        HealerFirstName = scan.next();//HealerFirstName is "global"
                        
                        /*add character name variable "HealerFirstName" to
                        loadedCharacters linked list to be accessed in other 
                        parts of the program (like selecting an existing 
                        character)*/
                        loadedCharacters.add(HealerFirstName);/*linked list "loaded
                        characters" is "global"*/
                        
                        try//write HealerFirstName to HealerFirstName.txt file
                        {
                            /*HealerFirstName and HealerFirstName.txt can only
                            store one Healer character's First name, so the newly
                            created character's first name must be written to this txt
                            file which will later be read so that said character
                            name can be written to another file(which the user
                            will name and said txt file will also contain all of
                            the Healer Character's stats) after being created,
                            otherwise upon creating another Healer character,
                            the previously created one will be overwritten by
                            the newer one.*/
                            FileWriter writeStats = new FileWriter
                            ("src/HealerFirstName.txt");
                            writeStats.write(HealerFirstName);
                            writeStats.close();
                            
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Healer the currently selected character
                        /*if both lists are empty...add HealerFirstName then add
                        thisIsHealer (value 3)*/
                        if(selectedCharacter.isEmpty())
                        {
                            selectedCharacter.add(HealerFirstName);
                            
                            if(selectedCharacterClass.isEmpty())
                            {
                                /*values that are added to the selectedCharacterClass
                                list are added after the first name of a character
                                is added to the selectedCharacter list.*/
                                selectedCharacterClass.add(thisIsHealer);
                                
                            }
                            
                        }
                        /*If not empty then clear it to make way for the Healer
                        Character to be the currently selected character. And
                        make way for the selectedCharacterClass to add the correct
                        value for the class that is being created.*/
                        else
                        {
                            selectedCharacter.clear();
                            selectedCharacter.add(HealerFirstName);
                            selectedCharacterClass.clear();
                            selectedCharacterClass.add(thisIsHealer);
                        }
                        
                        //-----------------------------------------------------
                        /*do the same thing like above, but with the Healer's 
                        last name*/
                        
                        System.out.print("Enter the last name of your Healer"+
                        " character: ");
                        HealerLastName = scan.next();//HealerLastName is "global"
                        
                        /*add character name variable "HealerLastName" to
                        loadedCharacters linked list to be accessed in other 
                        parts of the program (like selecting an existing 
                        character)*/
                        loadedCharacters.add(HealerLastName);/*linked list "loaded
                        characters" is "global"*/
                        
                        try//write HealerLastName to HealerLastName.txt file
                        {
                            /*HealerLastName and HealerLastName.txt can only
                            store one Healer character's last name, so the newly
                            created character's name must be written to this txt
                            file which will later be read so that said character
                            name can be written to another file(which the user
                            will name and said txt file will also contain all of
                            the Healer Character's stats) after being created,
                            otherwise upon creating another Healer character,
                            the previously created one will be overwritten by
                            the newer one.*/
                            FileWriter writeStats = new FileWriter
                            ("src/HealerLastName.txt");
                            writeStats.write(HealerLastName);
                            writeStats.close();
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Healer the currently selected character
                        /*if selectedCharacter contains HealerFirstName...add
                        HealerLastName */
                        if(selectedCharacter.contains(HealerFirstName))
                        {
                            selectedCharacter.add(HealerLastName);
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
                    //Martial Artist Class Creation
                    else if(characterCreationMenu == 4)
                    {
                        /*range.txt holds the numbers in the range of 1-1000 so
                        that it can be read from to provide random numbers in
                        said range so that in character creation the user can
                        pick 5 of said random numbers to be used for their 
                        5 stats (Accuracy, Attack, Damage, Physical Defense,
                        and Magical Defense).*/
                        File rangeText = new File("src/range.txt");
                        Scanner scanRange = new Scanner(rangeText);
                        int rangeInt1 = scanRange.nextInt();//1
                        int rangeInt2 = scanRange.nextInt();//1000
                        Random generator = new Random();
                    
                        int randomNum1;
                        int randomNum2;
                        int randomNum3;
                        int randomNum4;
                        int randomNum5;
                        
                        /*random # between 1-1000*/
                        randomNum1 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum2 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum3 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum4 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum5 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*the above random num values are later stored in these 
                        variables below so that the user can select from randomly 
                        generated stat values for each stat which will then be 
                        written to a txt file so that its value can be read/
                        loaded later on*/
                        /*these stat variables below are written to their txt files
                        as strings. Every stat variable in the program is either
                        read from a txt file or written to a txt file as a
                        string*/
                        int randomAccuracyStat;
                        int randomAttackStat;
                        int randomDamageStat;
                        int randomPhyDefStat;
                        int randomMagDefStat;
                        
                        /*stores the randomNumbers that are used for the
                        Martial Artist' stats so that more than one random number is
                        not applied to more than one stat*/
                        ArrayList<Integer> randomNumTaken = new ArrayList();
                        
                        System.out.println("Martial Artist Class Build");
                        System.out.println("-----------------------");
                        System.out.println("Character stats: Accuracy, Attack,"+
                        " Damage, Physical Defense, and Magical Defense");
                        System.out.println();
                        System.out.println("Random numbers to use for your"+
                        " stats: A."+randomNum1+"  B."+randomNum2+"  C"+
                        "."+randomNum3+"  D."+randomNum4+"  E."+randomNum5);
                        System.out.println();
                        System.out.println("Select a letter from above to add"+
                        " its numeric value to the stat you want it added\nto."+
                        " You can't use the same letter/value more than once.");
                        System.out.println();
                        System.out.println("Example: Enter your Accuracy"+
                        " stat: C (this would make your Accuracy Stat equal"+
                        " to "+randomNum3+")");
                        System.out.println();
                        System.out.print("Enter your Accuracy stat: ");
                        String accuracyStatChoice;
                        accuracyStatChoice = scan.next();
                        System.out.println();
                        
                        //Accuracy Stat if statements for Martial Artist class
                        if(accuracyStatChoice.equals("a") ||
                           accuracyStatChoice.equals("A"))
                        {
                            randomAccuracyStat = randomNum1;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/MartialArtistAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum1);
                            
                        }
                        else if(accuracyStatChoice.equals("b") ||
                                accuracyStatChoice.equals("B"))
                        {
                            randomAccuracyStat = randomNum2;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/MartialArtistAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum2);
                        }
                        else if(accuracyStatChoice.equals("c") ||
                                accuracyStatChoice.equals("C"))
                        {
                            randomAccuracyStat = randomNum3;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/MartialArtistAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum3);
                        }
                        else if(accuracyStatChoice.equals("d") ||
                                accuracyStatChoice.equals("D"))
                        {
                            randomAccuracyStat = randomNum4;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/MartialArtistAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum4);
                        }
                        else if(accuracyStatChoice.equals("e") ||
                                accuracyStatChoice.equals("E"))
                        {
                            randomAccuracyStat = randomNum5;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/MartialArtistAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
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
                        
                        //Attack Stat if statements for Martial Artist Class
                        if(attackStatChoice.equals("a") ||
                           attackStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/MartialArtistAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("b") ||
                                attackStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/MartialArtistAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("c") ||
                                attackStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/MartialArtistAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("d") ||
                                attackStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/MartialArtistAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("e") ||
                                attackStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/MartialArtistAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
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
                        
                        //Damage Stat if statements for Martial Artist Class
                        if(damageStatChoice.equals("a") ||
                           damageStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/MartialArtistDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("b") ||
                                damageStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/MartialArtistDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("c") ||
                                damageStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/MartialArtistDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("d") ||
                                damageStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/MartialArtistDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("e") ||
                                damageStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/MartialArtistDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
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
                        
                        //Physical Defence Stat if statements for Martial Artist Class
                        if(phyDefStatChoice.equals("a") ||
                           phyDefStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/MartialArtistPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("b") ||
                                phyDefStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/MartialArtistPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("c") ||
                                phyDefStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/MartialArtistPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("d") ||
                                phyDefStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/MartialArtistPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("e") ||
                                phyDefStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/MartialArtistPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
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
                        
                        //Magical Defense Stat if statements for Martial Artist Class
                        if(magDefStatChoice.equals("a") ||
                           magDefStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/MartialArtistMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("b") ||
                                magDefStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/MartialArtistMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("c") ||
                                magDefStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/MartialArtistMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("d") ||
                                magDefStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/MartialArtistMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("e") ||
                                magDefStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/MartialArtistMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        
                        System.out.print("Enter the first name of your Martial"+
                        " Artist character: ");
                        MartialArtistFirstName = scan.next();/*MartialArtist
                        FirstName is "global"*/
                        
                        /*add character name variable "MartialArtistFirstName" to
                        loadedCharacters linked list to be accessed in other 
                        parts of the program (like selecting an existing 
                        character)*/
                        loadedCharacters.add(MartialArtistFirstName);/*
                        linked list "loaded
                        characters" is "global"*/
                        
                        try/*write MartialArtistFirstName to
                            MartialArtistFirstName.txt file*/
                        {
                            /*MartialArtistFirstName and 
                            MartialArtistFirstName.txt can only
                            store one Martial Artist character's First name,
                            so the newly
                            created character's first name must be written to
                            this txt
                            file which will later be read so that said character
                            name can be written to another file(which the user
                            will name and said txt file will also contain all of
                            the Martial Artist Character's stats) after being
                            created,
                            otherwise upon creating another Martial Artist
                            character,
                            the previously created one will be overwritten by
                            the newer one.*/
                            FileWriter writeStats = new FileWriter
                            ("src/MartialArtistFirstName.txt");
                            writeStats.write(MartialArtistFirstName);
                            writeStats.close();
                            
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Martial Artist the currently selected character
                        /*if both lists are empty...add MartialArtistFirstName
                        then add thisIsMartialArtist (value 4)*/
                        if(selectedCharacter.isEmpty())
                        {
                            selectedCharacter.add(MartialArtistFirstName);
                            
                            if(selectedCharacterClass.isEmpty())
                            {
                                /*values that are added to the 
                                selectedCharacterClass
                                list are added after the first name of a character
                                is added to the selectedCharacter list.*/
                                selectedCharacterClass.add(thisIsMartialArtist);
                                
                            }
                            
                        }
                        /*If not empty then clear it to make way for the 
                        Martial Artist
                        Character to be the currently selected character. And
                        make way for the selectedCharacterClass to add the
                        correct
                        value for the class that is being created.*/
                        else
                        {
                            selectedCharacter.clear();
                            selectedCharacter.add(MartialArtistFirstName);
                            selectedCharacterClass.clear();
                            selectedCharacterClass.add(thisIsMartialArtist);
                        }
                        
                        //-----------------------------------------------------
                        /*do the same thing like above, but with the Martial Artist'
                        last name*/
                        
                        System.out.print("Enter the last name of your"+
                        " Martial Artist character: ");
                        MartialArtistLastName = scan.next();/*
                        MartialArtistLastName is "global"*/
                        
                        /*add character name variable "MartialArtistLastName" to
                        loadedCharacters linked list to be accessed in other 
                        parts of the program (like selecting an existing 
                        character)*/
                        loadedCharacters.add(MartialArtistLastName);/*
                        linked list "loaded
                        characters" is "global"*/
                        
                        try/*write MartialArtistLastName to 
                            MartialArtistLastName.txt file*/
                        {
                            /*MartialArtistLastName and 
                            MartialArtistLastName.txt can only
                            store one Martial Artist character's last name,
                            so the newly
                            created character's name must be written to this
                            txt
                            file which will later be read so that said character
                            name can be written to another file(which the user
                            will name and said txt file will also contain all of
                            the Martial Artist Character's stats) after being
                            created,
                            otherwise upon creating another Martial Artist
                            character,
                            the previously created one will be overwritten by
                            the newer one.*/
                            FileWriter writeStats = new FileWriter
                            ("src/MartialArtistLastName.txt");
                            writeStats.write(MartialArtistLastName);
                            writeStats.close();
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Martial Artist the currently selected character
                        /*if selectedCharacter contains MartialArtistFirstName
                        ...add MartialArtistLastName */
                        if(selectedCharacter.contains(MartialArtistFirstName))
                        {
                            selectedCharacter.add(MartialArtistLastName);
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
                    
                    //Necromancer Class Creation
                    else if(characterCreationMenu == 5)
                    {
                        /*range.txt holds the numbers in the range of 1-1000 so
                        that it can be read from to provide random numbers in
                        said range so that in character creation the user can
                        pick 5 of said random numbers to be used for their 
                        5 stats (Accuracy, Attack, Damage, Physical Defense,
                        and Magical Defense).*/
                        File rangeText = new File("src/range.txt");
                        Scanner scanRange = new Scanner(rangeText);
                        int rangeInt1 = scanRange.nextInt();//1
                        int rangeInt2 = scanRange.nextInt();//1000
                        Random generator = new Random();
                    
                        int randomNum1;
                        int randomNum2;
                        int randomNum3;
                        int randomNum4;
                        int randomNum5;
                        
                        /*random # between 1-1000*/
                        randomNum1 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum2 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum3 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum4 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum5 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*the above random num values are later stored in these 
                        variables below so that the user can select from randomly 
                        generated stat values for each stat which will then be 
                        written to a txt file so that its value can be read/
                        loaded later on*/
                        /*these stat variables below are written to their txt files
                        as strings. Every stat variable in the program is either
                        read from a txt file or written to a txt file as a
                        string*/
                        int randomAccuracyStat;
                        int randomAttackStat;
                        int randomDamageStat;
                        int randomPhyDefStat;
                        int randomMagDefStat;
                        
                        /*stores the randomNumbers that are used for the
                        Necromancer's stats so that more than one random number is
                        not applied to more than one stat*/
                        ArrayList<Integer> randomNumTaken = new ArrayList();
                        
                        System.out.println("Necromancer Class Build");
                        System.out.println("-----------------------");
                        System.out.println("Character stats: Accuracy, Attack,"+
                        " Damage, Physical Defense, and Magical Defense");
                        System.out.println();
                        System.out.println("Random numbers to use for your"+
                        " stats: A."+randomNum1+"  B."+randomNum2+"  C"+
                        "."+randomNum3+"  D."+randomNum4+"  E."+randomNum5);
                        System.out.println();
                        System.out.println("Select a letter from above to add"+
                        " its numeric value to the stat you want it added\nto."+
                        " You can't use the same letter/value more than once.");
                        System.out.println();
                        System.out.println("Example: Enter your Accuracy"+
                        " stat: C (this would make your Accuracy Stat equal"+
                        " to "+randomNum3+")");
                        System.out.println();
                        System.out.print("Enter your Accuracy stat: ");
                        String accuracyStatChoice;
                        accuracyStatChoice = scan.next();
                        System.out.println();
                        
                        //Accuracy Stat if statements for Necromancer class
                        if(accuracyStatChoice.equals("a") ||
                           accuracyStatChoice.equals("A"))
                        {
                            randomAccuracyStat = randomNum1;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/NecromancerAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum1);
                            
                        }
                        else if(accuracyStatChoice.equals("b") ||
                                accuracyStatChoice.equals("B"))
                        {
                            randomAccuracyStat = randomNum2;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/NecromancerAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum2);
                        }
                        else if(accuracyStatChoice.equals("c") ||
                                accuracyStatChoice.equals("C"))
                        {
                            randomAccuracyStat = randomNum3;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/NecromancerAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum3);
                        }
                        else if(accuracyStatChoice.equals("d") ||
                                accuracyStatChoice.equals("D"))
                        {
                            randomAccuracyStat = randomNum4;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/NecromancerAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum4);
                        }
                        else if(accuracyStatChoice.equals("e") ||
                                accuracyStatChoice.equals("E"))
                        {
                            randomAccuracyStat = randomNum5;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/NecromancerAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
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
                        
                        //Attack Stat if statements for Necromancer Class
                        if(attackStatChoice.equals("a") ||
                           attackStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/NecromancerAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("b") ||
                                attackStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/NecromancerAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("c") ||
                                attackStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/NecromancerAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("d") ||
                                attackStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/NecromancerAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("e") ||
                                attackStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/NecromancerAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
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
                        
                        //Damage Stat if statements for Necromancer Class
                        if(damageStatChoice.equals("a") ||
                           damageStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/NecromancerDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("b") ||
                                damageStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/NecromancerDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("c") ||
                                damageStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/NecromancerDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("d") ||
                                damageStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/NecromancerDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("e") ||
                                damageStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/NecromancerDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
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
                        
                        //Physical Defence Stat if statements for Necromancer Class
                        if(phyDefStatChoice.equals("a") ||
                           phyDefStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/NecromancerPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("b") ||
                                phyDefStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/NecromancerPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("c") ||
                                phyDefStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/NecromancerPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("d") ||
                                phyDefStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/NecromancerPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("e") ||
                                phyDefStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/NecromancerPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
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
                        
                        //Magical Defense Stat if statements for Necromancer Class
                        if(magDefStatChoice.equals("a") ||
                           magDefStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/NecromancerMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("b") ||
                                magDefStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/NecromancerMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("c") ||
                                magDefStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/NecromancerMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("d") ||
                                magDefStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/NecromancerMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("e") ||
                                magDefStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/NecromancerMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        
                        System.out.print("Enter the first name of your"+
                        " Necromancer character: ");
                        NecromancerFirstName = scan.next();/*
                        NecromancerFirstName is "global"*/
                        
                        /*add character name variable "NecromancerFirstName" to
                        loadedCharacters linked list to be accessed in other 
                        parts of the program (like selecting an existing 
                        character)*/
                        loadedCharacters.add(NecromancerFirstName);/*
                        linked list "loaded characters" is "global"*/
                        
                        try//write NecromancerFirstName to NecromancerFirstName.txt file
                        {
                            /*NecromancerFirstName and 
                            NecromancerFirstName.txt can only
                            store one Necromancer character's First name, 
                            so the newly
                            created character's first name must be written 
                            to this txt
                            file which will later be read so that said character
                            name can be written to another file(which the user
                            will name and said txt file will also contain all of
                            the Necromancer Character's stats) after being created,
                            otherwise upon creating another Necromancer character,
                            the previously created one will be overwritten by
                            the newer one.*/
                            FileWriter writeStats = new FileWriter
                            ("src/NecromancerFirstName.txt");
                            writeStats.write(NecromancerFirstName);
                            writeStats.close();
                            
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Necromancer the currently selected character
                        /*if both lists are empty...add NecromancerFirstName
                        then add thisIsNecromancer (value 5)*/
                        if(selectedCharacter.isEmpty())
                        {
                            selectedCharacter.add(NecromancerFirstName);
                            
                            if(selectedCharacterClass.isEmpty())
                            {
                                /*values that are added to the selectedCharacterClass
                                list are added after the first name of a character
                                is added to the selectedCharacter list.*/
                                selectedCharacterClass.add(thisIsNecromancer);
                                
                            }
                            
                        }
                        /*If not empty then clear it to make way for the Necromancer
                        Character to be the currently selected character. And
                        make way for the selectedCharacterClass to add the correct
                        value for the class that is being created.*/
                        else
                        {
                            selectedCharacter.clear();
                            selectedCharacter.add(NecromancerFirstName);
                            selectedCharacterClass.clear();
                            selectedCharacterClass.add(thisIsNecromancer);
                        }
                        
                        //-----------------------------------------------------
                        /*do the same thing like above, but with the Necromancer's
                        last name*/
                        
                        System.out.print("Enter the last name of your"+
                        " Necromancer character: ");
                        NecromancerLastName = scan.next();/*
                        NecromancerLastName is "global"*/
                        
                        /*add character name variable "NecromancerLastName" to
                        loadedCharacters linked list to be accessed in other 
                        parts of the program (like selecting an existing 
                        character)*/
                        loadedCharacters.add(NecromancerLastName);/*
                        linked list "loaded
                        characters" is "global"*/
                        
                        try//write NecromancerLastName to NecromancerLastName.txt file
                        {
                            /*NecromancerLastName and NecromancerLastName.txt 
                            can only
                            store one Necromancer character's last name, so the
                            newly
                            created character's name must be written to this txt
                            file which will later be read so that said character
                            name can be written to another file(which the user
                            will name and said txt file will also contain all of
                            the Necromancer Character's stats) after being created,
                            otherwise upon creating another Necromancer character,
                            the previously created one will be overwritten by
                            the newer one.*/
                            FileWriter writeStats = new FileWriter
                            ("src/NecromancerLastName.txt");
                            writeStats.write(NecromancerLastName);
                            writeStats.close();
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }

                        //make the Necromancer the currently selected character
                        /*if selectedCharacter contains NecromancerFirstName
                        ...add NecromancerLastName */
                        if(selectedCharacter.contains(NecromancerFirstName))
                        {
                            selectedCharacter.add(NecromancerLastName);
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
                    
                    //Wizard Class Creation
                    else if(characterCreationMenu == 6)
                    {
                        /*range.txt holds the numbers in the range of 1-1000 so
                        that it can be read from to provide random numbers in
                        said range so that in character creation the user can
                        pick 5 of said random numbers to be used for their 
                        5 stats (Accuracy, Attack, Damage, Physical Defense,
                        and Magical Defense).*/
                        File rangeText = new File("src/range.txt");
                        Scanner scanRange = new Scanner(rangeText);
                        int rangeInt1 = scanRange.nextInt();//1
                        int rangeInt2 = scanRange.nextInt();//1000
                        Random generator = new Random();
                    
                        int randomNum1;
                        int randomNum2;
                        int randomNum3;
                        int randomNum4;
                        int randomNum5;
                        
                        /*random # between 1-1000*/
                        randomNum1 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum2 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum3 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum4 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-1000*/
                        randomNum5 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*the above random num values are later stored in these 
                        variables below so that the user can select from randomly 
                        generated stat values for each stat which will then be 
                        written to a txt file so that its value can be read/
                        loaded later on*/
                        /*these stat variables below are written to their txt files
                        as strings. Every stat variable in the program is either
                        read from a txt file or written to a txt file as a
                        string*/
                        int randomAccuracyStat;
                        int randomAttackStat;
                        int randomDamageStat;
                        int randomPhyDefStat;
                        int randomMagDefStat;
                        
                        /*stores the randomNumbers that are used for the
                        Wizard's stats so that more than one random number is
                        not applied to more than one stat*/
                        ArrayList<Integer> randomNumTaken = new ArrayList();
                        
                        System.out.println("Wizard Class Build");
                        System.out.println("-----------------------");
                        System.out.println("Character stats: Accuracy, Attack,"+
                        " Damage, Physical Defense, and Magical Defense");
                        System.out.println();
                        System.out.println("Random numbers to use for your"+
                        " stats: A."+randomNum1+"  B."+randomNum2+"  C"+
                        "."+randomNum3+"  D."+randomNum4+"  E."+randomNum5);
                        System.out.println();
                        System.out.println("Select a letter from above to add"+
                        " its numeric value to the stat you want it added\nto."+
                        " You can't use the same letter/value more than once.");
                        System.out.println();
                        System.out.println("Example: Enter your"+
                        " Accuracy stat: C (this would make your Accuracy Stat"+
                        " equal to "+randomNum3+")");
                        System.out.println();
                        System.out.print("Enter your Accuracy stat: ");
                        String accuracyStatChoice;
                        accuracyStatChoice = scan.next();
                        System.out.println();
                        
                        //Accuracy Stat if statements for Wizard class
                        if(accuracyStatChoice.equals("a") ||
                           accuracyStatChoice.equals("A"))
                        {
                            randomAccuracyStat = randomNum1;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/WizardAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum1);
                            
                        }
                        else if(accuracyStatChoice.equals("b") ||
                                accuracyStatChoice.equals("B"))
                        {
                            randomAccuracyStat = randomNum2;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/WizardAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum2);
                        }
                        else if(accuracyStatChoice.equals("c") ||
                                accuracyStatChoice.equals("C"))
                        {
                            randomAccuracyStat = randomNum3;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/WizardAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum3);
                        }
                        else if(accuracyStatChoice.equals("d") ||
                                accuracyStatChoice.equals("D"))
                        {
                            randomAccuracyStat = randomNum4;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/WizardAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                            randomNumTaken.add(randomNum4);
                        }
                        else if(accuracyStatChoice.equals("e") ||
                                accuracyStatChoice.equals("E"))
                        {
                            randomAccuracyStat = randomNum5;
                            try
                            {
                                FileWriter writeStats = new FileWriter
                                ("src/WizardAccuracyStat.txt");
                                writeStats.write(String.
                                        valueOf(randomAccuracyStat));
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
                        
                        //Attack Stat if statements for Wizard Class
                        if(attackStatChoice.equals("a") ||
                           attackStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/WizardAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("b") ||
                                attackStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/WizardAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("c") ||
                                attackStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/WizardAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("d") ||
                                attackStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/WizardAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(attackStatChoice.equals("e") ||
                                attackStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/WizardAttackStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomAttackStat));
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
                        
                        //Damage Stat if statements for Wizard Class
                        if(damageStatChoice.equals("a") ||
                           damageStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/WizardDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("b") ||
                                damageStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/WizardDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("c") ||
                                damageStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/WizardDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("d") ||
                                damageStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/WizardDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(damageStatChoice.equals("e") ||
                                damageStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/WizardDamageStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomDamageStat));
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
                        
                        //Physical Defence Stat if statements for Wizard Class
                        if(phyDefStatChoice.equals("a") ||
                           phyDefStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/WizardPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("b") ||
                                phyDefStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/WizardPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("c") ||
                                phyDefStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/WizardPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("d") ||
                                phyDefStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/WizardPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(phyDefStatChoice.equals("e") ||
                                phyDefStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/WizardPhyDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomPhyDefStat));
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
                        
                        //Magical Defense Stat if statements for Wizard Class
                        if(magDefStatChoice.equals("a") ||
                           magDefStatChoice.equals("A"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/WizardMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("b") ||
                                magDefStatChoice.equals("B"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/WizardMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("c") ||
                                magDefStatChoice.equals("C"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/WizardMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("d") ||
                                magDefStatChoice.equals("D"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/WizardMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        else if(magDefStatChoice.equals("e") ||
                                magDefStatChoice.equals("E"))
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
                                    FileWriter writeStats = new FileWriter
                                    ("src/WizardMagDefStat.txt");
                                    writeStats.write(String.
                                            valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        
                        System.out.print("Enter the first name of your"+
                        " Wizard character: ");
                        WizardFirstName = scan.next();/*
                        WizardFirstName is "global"*/
                        
                        /*add character name variable "WizardFirstName" to
                        loadedCharacters linked list to be accessed in other 
                        parts of the program (like selecting an existing 
                        character)*/
                        loadedCharacters.add(WizardFirstName);/*
                        linked list "loaded
                        characters" is "global"*/
                        
                        try//write WizardFirstName to WizardFirstName.txt file
                        {
                            /*WizardFirstName and WizardFirstName.txt can only
                            store one Wizard character's First name, so the newly
                            created character's first name must be written to 
                            this txt
                            file which will later be read so that said character
                            name can be written to another file(which the user
                            will name and said txt file will also contain all of
                            the Wizard Character's stats) after being created,
                            otherwise upon creating another Wizard character,
                            the previously created one will be overwritten by
                            the newer one.*/
                            FileWriter writeStats = new FileWriter
                            ("src/WizardFirstName.txt");
                            writeStats.write(WizardFirstName);
                            writeStats.close();
                            
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Wizard the currently selected character
                        /*if both lists are empty...add WizardFirstName then add
                        thisIsWizard (value 6)*/
                        if(selectedCharacter.isEmpty())
                        {
                            selectedCharacter.add(WizardFirstName);
                            
                            if(selectedCharacterClass.isEmpty())
                            {
                                /*values that are added to the 
                                selectedCharacterClass
                                list are added after the first name of a 
                                character
                                is added to the selectedCharacter list.*/
                                selectedCharacterClass.add(thisIsWizard);
                                
                            }
                            
                        }
                        /*If not empty then clear it to make way for the Wizard
                        Character to be the currently selected character. And
                        make way for the selectedCharacterClass to add the correct
                        value for the class that is being created.*/
                        else
                        {
                            selectedCharacter.clear();
                            selectedCharacter.add(WizardFirstName);
                            selectedCharacterClass.clear();
                            selectedCharacterClass.add(thisIsWizard);
                        }
                        
                        //-----------------------------------------------------
                        /*do the same thing like above, but with the Wizard's
                        last name*/
                        
                        System.out.print("Enter the last name of your"+
                        " Wizard character: ");
                        WizardLastName = scan.next();//WizardLastName is "global"
                        
                        /*add character name variable "WizardLastName" to
                        loadedCharacters linked list to be accessed in other 
                        parts of the program (like selecting an existing 
                        character)*/
                        loadedCharacters.add(WizardLastName);/*linked list "loaded
                        characters" is "global"*/
                        
                        try//write WizardLastName to WizardLastName.txt file
                        {
                            /*WizardLastName and WizardLastName.txt can only
                            store one Wizard character's last name, so the newly
                            created character's name must be written to this txt
                            file which will later be read so that said character
                            name can be written to another file(which the user
                            will name and said txt file will also contain all of
                            the Wizard Character's stats) after being created,
                            otherwise upon creating another Wizard character,
                            the previously created one will be overwritten by
                            the newer one.*/
                            FileWriter writeStats = new FileWriter
                            ("src/WizardLastName.txt");
                            writeStats.write(WizardLastName);
                            writeStats.close();
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Wizard the currently selected character
                        /*if selectedCharacter contains WizardFirstName...add
                        WizardLastName */
                        if(selectedCharacter.contains(WizardFirstName))
                        {
                            selectedCharacter.add(WizardLastName);
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
                    //character creation menu while loop
                    System.out.println("Character Creation");
                    System.out.println("-----------------------");
                    System.out.print("Enter 0 to preview all classes, 1 to create"+
                    " an Assassin, 2 for an Engineer, 3 for a Healer,\n4 for a"+
                    " Martial Artist, 5 for a Necromancer, 6 for a Wizard, or"+
                    " 7 to quit: ");
                    characterCreationMenu = scan.nextInt();
                    System.out.println();
                    System.out.println();
                }
                    
            }
            
            /*When selecting an existing character from here (#2 userMainMenu)
            the user is opting to select characters that were created during the
            programs runtime or characters they loaded from a save file that
            they themselves would have named.*/
            
            else if(userMainMenu == 2)
            {
                
                
                /*if the files that are read in this try are not present in the
                src folder, then the catch of this try will catch a 
                "FileNotFoundException error and tell the user that they must 
                first either create or load a character from a save file if they
                want to select an existing character.*/
                try
                {
                    
                    System.out.println("Select an Existing Character");
                    System.out.println("--------------------------------");
                    System.out.println("Only one character per class can"+
                    " be available"+
                    " for selection.\nIf you want to select a different"+
                    " character"+
                    " for your desired\nclass then you must create a new"+
                    " character"+
                    " for that class or\nload a saved file of a previously"+
                    " created"+
                    " character for that\nclass.");
                    System.out.println();
                    
                    
                    //START: display an available Assassin Character if possible
                    //----------------------------------------------------------
                    //will retrieve AssassinFirstName.txt
                    File Assassin1stFile = new File("src/AssassinFirstName.txt");
                    Scanner scanAssassinFirstName = new Scanner(Assassin1stFile);
                    
                    //will retrieve AssassinLastName.txt
                    File Assassin2ndFile = new File("src/AssassinLastName.txt");
                    Scanner scanAssassinLastName = new Scanner(Assassin2ndFile);
                
                    String AssassinFirstNameValue;
                    String AssassinLastNameValue;
                    
                    String AssassinFirstNameTxt = 
                            scanAssassinFirstName.next();
                    String AssassinLastNameTxt = scanAssassinLastName.next();
                    
                    AssassinFirstNameValue = String.
                            valueOf(AssassinFirstNameTxt);
                    AssassinLastNameValue = String.
                            valueOf(AssassinLastNameTxt);
                    
                    //if no Assassin character has been created or loaded
                    if(AssassinFirstNameValue.equals("0") &&
                        AssassinLastNameValue.equals("0"))
                    {
       
                        String NoCharacterAlert1 = "1. No character has been"+
                        " created or loaded for the Assassin class so none can"+
                        " be selected";
                        System.out.println(NoCharacterAlert1);
                    }
                    
                    /*if an Assassin character has been created or loaded
                    display their name and class as an option to be selected*/
                    else
                    {
                        System.out.println("1. "+AssassinFirstNameValue+" "+
                            AssassinLastNameValue+" (Assassin Class)");
                    }
                    
                    //END: Assassin Character display ends
                    //----------------------------------------------------------
                
                
                    //START: display an available Engineer Character if possible
                    //----------------------------------------------------------
                    //will retrieve EngineerFirstName.txt
                    File Engineer1stFile = new File("src/EngineerFirstName.txt");
                    Scanner scanEngineerFirstName = new Scanner(Engineer1stFile);
                    
                    //will retrieve EngineerLastName.txt
                    File Engineer2ndFile = new File("src/EngineerLastName.txt");
                    Scanner scanEngineerLastName = new Scanner(Engineer2ndFile);
                
                    String EngineerFirstNameValue;
                    String EngineerLastNameValue;
                    
                    String EngineerFirstNameTxt = 
                            scanEngineerFirstName.next();
                    String EngineerLastNameTxt = scanEngineerLastName.next();
                    
                    EngineerFirstNameValue = String.
                            valueOf(EngineerFirstNameTxt);
                    EngineerLastNameValue = String.
                            valueOf(EngineerLastNameTxt);
                    
                    //if no Engineer character has been created or loaded
                    if(EngineerFirstNameValue.equals("0") &&
                        EngineerLastNameValue.equals("0"))
                    {
       
                        String NoCharacterAlert2 = "2. No character has been"+
                        " created or loaded for the Engineer class so none can"+
                        " be selected";
                        System.out.println(NoCharacterAlert2);
                    }
                    
                    /*if an Engineer character has been created or loaded
                    display their name and class as an option to be selected*/
                    else
                    {
                        System.out.println("2. "+EngineerFirstNameValue+" "+
                            EngineerLastNameValue+" (Engineer Class)");
                    }
                    
                    //END: Engineer Character display ends
                    //----------------------------------------------------------
                
                
                    //START: display an available Healer Character if possible
                    //----------------------------------------------------------
                    //will retrieve HealerFirstName.txt
                    File Healer1stFile = new File("src/HealerFirstName.txt");
                    Scanner scanHealerFirstName = new Scanner(Healer1stFile);
                    
                    //will retrieve HealerLastName.txt
                    File Healer2ndFile = new File("src/HealerLastName.txt");
                    Scanner scanHealerLastName = new Scanner(Healer2ndFile);
                
                    String HealerFirstNameValue;
                    String HealerLastNameValue;
                    
                    String HealerFirstNameTxt = 
                            scanHealerFirstName.next();
                    String HealerLastNameTxt = scanHealerLastName.next();
                    
                    HealerFirstNameValue = String.
                            valueOf(HealerFirstNameTxt);
                    HealerLastNameValue = String.
                            valueOf(HealerLastNameTxt);
                    
                    //if no Healer character has been created or loaded
                    if(HealerFirstNameValue.equals("0") &&
                        HealerLastNameValue.equals("0"))
                    {
       
                        String NoCharacterAlert3 = "3. No character has been"+
                        " created or loaded for the Healer class so none can"+
                        " be selected";
                        System.out.println(NoCharacterAlert3);
                    }
                    
                    /*if a Healer character has been created or loaded
                    display their name and class as an option to be selected*/
                    else
                    {
                        System.out.println("3. "+HealerFirstNameValue+" "+
                            HealerLastNameValue+" (Healer Class)");
                    }
                    
                    //END: Healer Character display ends
                    //----------------------------------------------------------
                
                
                    /*START: display an available Martial Artist
                    Character if possible*/
                    //----------------------------------------------------------
                    //will retrieve MartialArtistFirstName.txt
                    File MartialArtist1stFile = 
                            new File("src/MartialArtistFirstName.txt");
                    Scanner scanMartialArtistFirstName = 
                            new Scanner(MartialArtist1stFile);
                    
                    //will retrieve MartialArtistLastName.txt
                    File MartialArtist2ndFile = 
                            new File("src/MartialArtistLastName.txt");
                    Scanner scanMartialArtistLastName = 
                            new Scanner(MartialArtist2ndFile);
                
                    String MartialArtistFirstNameValue;
                    String MartialArtistLastNameValue;
                    
                    String MartialArtistFirstNameTxt = 
                            scanMartialArtistFirstName.next();
                    String MartialArtistLastNameTxt = 
                            scanMartialArtistLastName.next();
                    
                    MartialArtistFirstNameValue = String.
                            valueOf(MartialArtistFirstNameTxt);
                    MartialArtistLastNameValue = String.
                            valueOf(MartialArtistLastNameTxt);
                    
                    //if no MartialArtist character has been created or loaded
                    if(MartialArtistFirstNameValue.equals("0") &&
                        MartialArtistLastNameValue.equals("0"))
                    {
       
                        String NoCharacterAlert4 = "4. No character has been"+
                        " created or loaded for the Martial Artist"+
                        " class so none can"+
                        " be selected";
                        System.out.println(NoCharacterAlert4);
                    }
                    
                    /*if a Martial Artist character has been created or loaded
                    display their name and class as an option to be selected*/
                    else
                    {
                        System.out.println("4. "+MartialArtistFirstNameValue+" "+
                            MartialArtistLastNameValue+" (Martial Artist Class)");
                    }
                    
                    //END: Martial Artist Character display ends
                    //----------------------------------------------------------
                
                
                    /*START: display an available Necromancer
                    Character if possible*/
                    //----------------------------------------------------------
                    //will retrieve NecromancerFirstName.txt
                    File Necromancer1stFile = 
                            new File("src/NecromancerFirstName.txt");
                    Scanner scanNecromancerFirstName = 
                            new Scanner(Necromancer1stFile);
                    
                    //will retrieve NecromancerLastName.txt
                    File Necromancer2ndFile = 
                            new File("src/NecromancerLastName.txt");
                    Scanner scanNecromancerLastName = 
                            new Scanner(Necromancer2ndFile);
                
                    String NecromancerFirstNameValue;
                    String NecromancerLastNameValue;
                    
                    String NecromancerFirstNameTxt = 
                            scanNecromancerFirstName.next();
                    String NecromancerLastNameTxt = 
                            scanNecromancerLastName.next();
                    
                    NecromancerFirstNameValue = String.
                            valueOf(NecromancerFirstNameTxt);
                    NecromancerLastNameValue = String.
                            valueOf(NecromancerLastNameTxt);
                    
                    //if no Necromancer character has been created or loaded
                    if(NecromancerFirstNameValue.equals("0") &&
                        NecromancerLastNameValue.equals("0"))
                    {
       
                        String NoCharacterAlert5 = "5. No character has been"+
                        " created or loaded for the Necromancer"+
                        " class so none can"+
                        " be selected";
                        System.out.println(NoCharacterAlert5);
                    }
                    
                    /*if a Necromancer character has been created or loaded
                    display their name and class as an option to be selected*/
                    else
                    {
                        System.out.println("5. "+NecromancerFirstNameValue+" "+
                            NecromancerLastNameValue+" (Necromancer Class)");
                    }
                    
                    //END: Necromancer Character display ends
                    //----------------------------------------------------------
                
                
                    /*START: display an available Wizard
                    Character if possible*/
                    //----------------------------------------------------------
                    //will retrieve WizardFirstName.txt
                    File Wizard1stFile = 
                            new File("src/WizardFirstName.txt");
                    Scanner scanWizardFirstName = 
                            new Scanner(Wizard1stFile);
                    
                    //will retrieve WizardLastName.txt
                    File Wizard2ndFile = 
                            new File("src/WizardLastName.txt");
                    Scanner scanWizardLastName = 
                            new Scanner(Wizard2ndFile);
                
                    String WizardFirstNameValue;
                    String WizardLastNameValue;
                    
                    String WizardFirstNameTxt = 
                            scanWizardFirstName.next();
                    String WizardLastNameTxt = scanWizardLastName.next();
                    
                    WizardFirstNameValue = String.
                            valueOf(WizardFirstNameTxt);
                    WizardLastNameValue = String.
                            valueOf(WizardLastNameTxt);
                    
                    //if no Wizard character has been created or loaded
                    if(WizardFirstNameValue.equals("0") &&
                        WizardLastNameValue.equals("0"))
                    {
       
                        String NoCharacterAlert6 = "6. No character has been"+
                        " created or loaded for the Wizard"+
                        " class so none can"+
                        " be selected";
                        System.out.println(NoCharacterAlert6);
                    }
                    
                    /*if a Wizard character has been created or loaded
                    display their name and class as an option to be selected*/
                    else
                    {
                        System.out.println("6. "+WizardFirstNameValue+" "+
                            WizardLastNameValue+" (Wizard Class)");
                    }
                    
                    //END: Wizard Character display ends
                    //----------------------------------------------------------
                    
                    //START: Exit display
                    //----------------------------------------------------------
                    System.out.println("7. Exit");
                    //END: Exit display
                    //----------------------------------------------------------
                
                    int userCharacterChoice;
                    System.out.println();
                    System.out.print("Enter the number of the character you want"+
                    " to select: ");
                    userCharacterChoice = scan.nextInt();
                    System.out.println();
                
                    //Make the currently selected character one of the Assassin class
                    if(userCharacterChoice == 1)
                    {
                        /*if the AssassinFirstName.txt and AssassinLastName.txt
                        files have no character names in them then do the below*/
                        
                        if(AssassinFirstNameValue.equals("0") &&
                            AssassinLastNameValue.equals("0"))
                        {
                            System.out.print("There is no Assassin character to"+
                            " select. You must create one or load one from a\nsave"+
                            " file. Press enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                        
                        }
                        /*if the AssassinFirstName.txt and AssassinLastName.txt
                        files have character names in them then do the below*/
                        else
                        {
                            
                            //make the Assassin the currently selected character
                            /*if both lists are empty...add AssassinFirstNameTxt
                            & 
                            AssassinLastNameTxt then add thisIsAssassin (value 1)
                            */
                            if(selectedCharacter.isEmpty())
                            {
                                selectedCharacter.add(AssassinFirstNameTxt);
                                selectedCharacter.add(AssassinLastNameTxt);
                            
                                if(selectedCharacterClass.isEmpty())
                                {
                                    /*determines that this character is of the
                                    Assassin Class*/
                                    selectedCharacterClass.add(thisIsAssassin);
                                
                                }
                            
                            }
                            /*If not empty then clear it to make way for the
                            Assassin
                            Character to be the currently selected character.
                            And
                            make way for the selectedCharacterClass to add the
                            correct
                            value for the class that is being created.*/
                            else
                            {
                                selectedCharacter.clear();
                                selectedCharacter.add(AssassinFirstNameTxt);
                                selectedCharacter.add(AssassinLastNameTxt);
                                selectedCharacterClass.clear();
                                selectedCharacterClass.add(thisIsAssassin);
                           }
                        }            
                    }
                 
                    /*Make the currently selected character one of the
                    Engineer class*/
                    else if(userCharacterChoice == 2)
                    {
                        /*if the EngineerFirstName.txt and EngineerLastName.txt
                        files have no character names in them then do the below*/
                        
                        if(EngineerFirstNameValue.equals("0") &&
                            EngineerLastNameValue.equals("0"))
                        {
                            System.out.print("There is no Engineer character to"+
                            " select. You must create one or load one"+
                            " from a\nsave"+
                            " file. Press enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                        
                        }
                        /*if the EngineerFirstName.txt and EngineerLastName.txt
                        files have character names in them then do the below*/
                        else
                        {
                            
                            //make the Engineer the currently selected character
                            /*if both lists are empty...add EngineerFirstNameTxt
                            & 
                            EngineerLastNameTxt then add thisIsEngineer (value 2)
                            */
                            if(selectedCharacter.isEmpty())
                            {
                                selectedCharacter.add(EngineerFirstNameTxt);
                                selectedCharacter.add(EngineerLastNameTxt);
                            
                                if(selectedCharacterClass.isEmpty())
                                {
                                    /*determines that this character is of the
                                    Engineer Class*/
                                    selectedCharacterClass.add(thisIsEngineer);
                                }
                            
                            }
                            /*If not empty then clear it to make way for the
                            Engineer
                            Character to be the currently selected character.
                            And
                            make way for the selectedCharacterClass to add the
                            correct
                            value for the class that is being created.*/
                            else
                            {
                                selectedCharacter.clear();
                                selectedCharacter.add(EngineerFirstNameTxt);
                                selectedCharacter.add(EngineerLastNameTxt);
                                selectedCharacterClass.clear();
                                selectedCharacterClass.add(thisIsEngineer);
                           }
                        }            
                    }
                
                    /*Make the currently selected character one of the
                    Healer class*/
                    else if(userCharacterChoice == 3)
                    {
                        /*if the HealerFirstName.txt and HealerLastName.txt
                        files have no character names in them then do the below*/
                        
                        if(HealerFirstNameValue.equals("0") &&
                            HealerLastNameValue.equals("0"))
                        {
                            System.out.print("There is no Healer character to"+
                            " select. You must create one or load one"+
                            " from a\nsave"+
                            " file. Press enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                        
                        }
                        /*if the HealerFirstName.txt and HealerLastName.txt
                        files have character names in them then do the below*/
                        else
                        {
                            
                            //make the Healer the currently selected character
                            /*if both lists are empty...add HealerFirstNameTxt
                            & 
                            HealerLastNameTxt then add thisIsHealer (value 3)
                            */
                            if(selectedCharacter.isEmpty())
                            {
                                selectedCharacter.add(HealerFirstNameTxt);
                                selectedCharacter.add(HealerLastNameTxt);
                            
                                if(selectedCharacterClass.isEmpty())
                                {
                                    /*determines that this character is of the
                                    Healer Class*/
                                    selectedCharacterClass.add(thisIsHealer);
                                }
                            
                            }
                            /*If not empty then clear it to make way for the
                            Healer
                            Character to be the currently selected character.
                            And
                            make way for the selectedCharacterClass to add the
                            correct
                            value for the class that is being created.*/
                            else
                            {
                                selectedCharacter.clear();
                                selectedCharacter.add(HealerFirstNameTxt);
                                selectedCharacter.add(HealerLastNameTxt);
                                selectedCharacterClass.clear();
                                selectedCharacterClass.add(thisIsHealer);
                           }
                        }            
                    }
                
                    /*Make the currently selected character one of the
                    Martial Artist class*/
                    else if(userCharacterChoice == 4)
                    {
                        /*if the MartialArtistFirstName.txt and
                        MartialArtistLastName.txt
                        files have no character names in them then do the below*/
                        
                        if(MartialArtistFirstNameValue.equals("0") &&
                            MartialArtistLastNameValue.equals("0"))
                        {
                            System.out.print("There is no Martial Artist"+
                            " character to"+
                            " select. You must create one or load one"+
                            " from a\nsave"+
                            " file. Press enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                        
                        }
                        /*if the MartialArtistFirstName.txt and
                        MartialArtistLastName.txt
                        files have character names in them then do the below*/
                        else
                        {
                            
                            /*make the MartialArtist the currently selected
                            character*/
                            /*if both lists are empty...add
                            MartialArtistFirstNameTxt
                            & MartialArtistNameTxt then add thisIsMartialArtist
                            (value 4)*/
                            if(selectedCharacter.isEmpty())
                            {
                                selectedCharacter.add(MartialArtistFirstNameTxt);
                                selectedCharacter.add(MartialArtistLastNameTxt);
                            
                                if(selectedCharacterClass.isEmpty())
                                {
                                    /*determines that this character is of the
                                    MartialArtist Class*/
                                    selectedCharacterClass.
                                            add(thisIsMartialArtist);
                                }
                            
                            }
                            /*If not empty then clear it to make way for the
                            MartialArtist
                            Character to be the currently selected character.
                            And
                            make way for the selectedCharacterClass to add the
                            correct
                            value for the class that is being created.*/
                            else
                            {
                                selectedCharacter.clear();
                                selectedCharacter.add(MartialArtistFirstNameTxt);
                                selectedCharacter.add(MartialArtistLastNameTxt);
                                selectedCharacterClass.clear();
                                selectedCharacterClass.add(thisIsMartialArtist);
                           }
                        }            
                    }
                
                    /*Make the currently selected character one of the
                    Necromancer class*/
                    else if(userCharacterChoice == 5)
                    {
                        /*if the NecromancerFirstName.txt and
                        NecromancerLastName.txt
                        files have no character names in them then do the below*/
                        
                        if(NecromancerFirstNameValue.equals("0") &&
                            NecromancerLastNameValue.equals("0"))
                        {
                            System.out.print("There is no Necromancer"+
                            " character to"+
                            " select. You must create one or load one"+
                            " from a\nsave"+
                            " file. Press enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                        
                        }
                        /*if the NecromancerFirstName.txt and
                        NecromancerLastName.txt
                        files have character names in them then do the below*/
                        else
                        {
                            
                            /*make the Necromancer the currently selected
                            character*/
                            /*if both lists are empty...add
                            NecromancerFirstNameTxt
                            & NecromancerNameTxt then add thisIsNecromancer
                            (value 4)*/
                            if(selectedCharacter.isEmpty())
                            {
                                selectedCharacter.add(NecromancerFirstNameTxt);
                                selectedCharacter.add(NecromancerLastNameTxt);
                            
                                if(selectedCharacterClass.isEmpty())
                                {
                                    /*determines that this character is of the
                                    Necromancer Class*/
                                    selectedCharacterClass.
                                            add(thisIsNecromancer);
                                }
                            }
                            /*If not empty then clear it to make way for the
                            Necromancer
                            Character to be the currently selected character.
                            And
                            make way for the selectedCharacterClass to add the
                            correct
                            value for the class that is being created.*/
                            else
                            {
                                selectedCharacter.clear();
                                selectedCharacter.add(NecromancerFirstNameTxt);
                                selectedCharacter.add(NecromancerLastNameTxt);
                                selectedCharacterClass.clear();
                                selectedCharacterClass.add(thisIsNecromancer);
                           }
                        }            
                    }
                
                    /*Make the currently selected character one of the
                    Wizard class*/
                    else if(userCharacterChoice == 6)
                    {
                        /*if the WizardFirstName.txt and
                        WizardLastName.txt
                        files have no character names in them then do the below*/
                        
                        if(WizardFirstNameValue.equals("0") &&
                            WizardLastNameValue.equals("0"))
                        {
                            System.out.print("There is no Wizard"+
                            " character to"+
                            " select. You must create one or load one"+
                            " from a\nsave"+
                            " file. Press enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                        
                        }
                        /*if the WizardFirstName.txt and
                        WizardLastName.txt
                        files have character names in them then do the below*/
                        else
                        {
                            
                            /*make the Wizard the currently selected
                            character*/
                            /*if both lists are empty...add
                            WizardFirstNameTxt
                            & WizardNameTxt then add thisIsWizard
                            (value 4)*/
                            if(selectedCharacter.isEmpty())
                            {
                                selectedCharacter.add(WizardFirstNameTxt);
                                selectedCharacter.add(WizardLastNameTxt);
                            
                                if(selectedCharacterClass.isEmpty())
                                {
                                    /*determines that this character is of the
                                    Wizard Class*/
                                    selectedCharacterClass.
                                            add(thisIsWizard);
                                }
                            }
                            /*If not empty then clear it to make way for the
                            Wizard
                            Character to be the currently selected character.
                            And
                            make way for the selectedCharacterClass to add the
                            correct
                            value for the class that is being created.*/
                            else
                            {
                                selectedCharacter.clear();
                                selectedCharacter.add(WizardFirstNameTxt);
                                selectedCharacter.add(WizardLastNameTxt);
                                selectedCharacterClass.clear();
                                selectedCharacterClass.add(thisIsWizard);
                           }
                        }            
                    }
                    
                    /*this else if statement and the else clause below it act
                    as a while loop (sort of). I would have added an actual while
                    loop but I am short on time- need to get to other things
                    in this program.*/
                    else if(userCharacterChoice == 7)
                    {
                        //do nothing, just exit the selection menu
                    }
                    
                    else
                    {
                        System.out.print("You must select a number"+
                                " that corresponds"+
                        " with an existing character,\nor enter 7 to exit."+
                        " Press enter to continue.");
                        try{System.in.read();}
                        catch(Exception e){}
                        System.out.println();
                        System.out.println();
                    }
                }
                
                /*if none of the files in the try above this catch can be read,
                then this is the message given to the user*/
                catch(FileNotFoundException exception)
                {
                    System.out.print("You have not created or loaded any"+
                    " characters. You must\ndo so to select an existing"+
                    " character. Press enter to continue.");
                    try{System.in.read();}
                    catch(Exception e){}
                    System.out.println();
                    System.out.println();
                }
            }
            
                
            else if(userMainMenu == 3)
            {
                /*if the user currently has a loaded character as their selected
                character and they then want to select a new character that has
                the same class as their current loaded character (i.e. both are
                Assassin Class game characters) and that new character has not
                been saved to a save file then the loaded characters stats will
                be added to that new character with no saved file. The loaded
                character can easily be reloaded again, but the new character
                which originally had no save file will not be able to get their
                old stats back. However, this is not a problem if the user heeds
                the programs warning and saves their character after it is
                created.*/
                
                //tell user how to locate their saved character files
                System.out.println("Load a character from file");
                System.out.println("--------------------------------");
                System.out.print("If you forgot the"+
                " name of your saved file(s), then locate them"+
                " by following this directory:\nyourPath\\CharacterManager\\"+
                "src\\SavedCharacters. Press enter to continue.");
                try{System.in.read();}
                catch(Exception e){}
                System.out.println();
                System.out.println();
                
                //get user to enter the save file they want to load
                String userSaveFile;
                System.out.print("Enter the name of your save file"+
                " to load your character: ");
                userSaveFile = scan.next();
                System.out.println();
                System.out.println();
                
                /*this try and its catch makes sure that whatever file the user
                enters to have loaded actually exists (or the user may have
                typed their file name in wrong), so that a FileNotFoundException
                does not appear*/
                try
                {
                    File userNamedFile = new File
                    ("src/SavedCharacters/"+userSaveFile+".txt");
                    Scanner scanUserNamedFile = new Scanner(userNamedFile);
                    /*read the first line of the user-named saved file to determine
                    the class of the character they want to load*/
                    String characterClass = scanUserNamedFile.nextLine();
                    
                    /*if the saved character of the user's save file is of the
                    Assassin Class*/
                    if(characterClass.contains("Assassin Class"))
                    {
                        /*Read the contents of a saved characters from a user named
                        save file and write it back to that character's respective
                        class files found in the "src" folder*/
                        File AssassinTxtFile = new File
                        ("src/SavedCharacters/"+userSaveFile+".txt");
                        Scanner scanAssassinClassTxtFile = new Scanner(AssassinTxtFile);
                    
                        /*this variable below is reading the same thing as
                        characterClass and is only needed to read that same line
                        again*/
                        String dontUseThisVariable = 
                                scanAssassinClassTxtFile.nextLine();
                    
                        String AssassinFirstNameTxt = 
                                scanAssassinClassTxtFile.next();
                    
                        String AssassinLastNameTxt = 
                                scanAssassinClassTxtFile.next();
                    
                        String AssassinAccuracyStatValue = 
                                scanAssassinClassTxtFile.next();
                    
                        String AssassinAttackStatValue = 
                                scanAssassinClassTxtFile.next();
                    
                        String AssassinDamageStatValue = 
                                scanAssassinClassTxtFile.next();
                    
                        String AssassinPhyDefStatValue = 
                                scanAssassinClassTxtFile.next();
                    
                        String AssassinMagDefStatValue = 
                                scanAssassinClassTxtFile.next();
                    
                        /*write the Assassin's first name from the user created txt
                        file to the AssassinFirstName.txt file*/
                        try
                        {
                        
                            FileWriter AssassinFirstNameWrite = 
                                    new FileWriter("src/AssassinFirstName.txt");
                            AssassinFirstNameWrite.write(AssassinFirstNameTxt);
                            AssassinFirstNameWrite.close();
                        }
                    
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                    
                        /*write the Assassin's last name from the user created
                        txt file to the AssassinLastName.txt file*/
                        try
                        {
                            FileWriter AssassinLastNameWrite = 
                                    new FileWriter("src/AssassinLastName.txt");
                            AssassinLastNameWrite.write(AssassinLastNameTxt);
                            AssassinLastNameWrite.close();
                        }
                    
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Assassin's Accuracy Stat value*/
                        try
                        {
                            FileWriter AssassinAccuracyStatWrite = 
                                    new FileWriter("src/AssassinAccuracyStat.txt");
                            AssassinAccuracyStatWrite.write(AssassinAccuracyStatValue);
                            AssassinAccuracyStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Assassin's Attack Stat value*/
                        try
                        {
                            FileWriter AssassinAttackStatWrite = 
                                    new FileWriter("src/AssassinAttackStat.txt");
                            AssassinAttackStatWrite.write(AssassinAttackStatValue);
                            AssassinAttackStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Assassin's Damage Stat value*/
                        try
                        {
                            FileWriter AssassinDamageStatWrite = 
                                    new FileWriter("src/AssassinDamageStat.txt");
                            AssassinDamageStatWrite.write(AssassinDamageStatValue);
                            AssassinDamageStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Assassin's Physical Defense Stat value*/
                        try
                        {
                            FileWriter AssassinPhyDefStatWrite = 
                                    new FileWriter("src/AssassinPhyDefStat.txt");
                            AssassinPhyDefStatWrite.write(AssassinPhyDefStatValue);
                            AssassinPhyDefStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Assassin's Magical Defense Stat value*/
                        try
                        {
                            FileWriter AssassinMagDefStatWrite = 
                                    new FileWriter("src/AssassinMagDefStat.txt");
                            AssassinMagDefStatWrite.write(AssassinMagDefStatValue);
                            AssassinMagDefStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        
                        /*make the Assassin from the user-created txt file
                        become the currently selected character*/
                        if(selectedCharacter.isEmpty())
                        {
                            selectedCharacter.add(AssassinFirstNameTxt);
                            selectedCharacter.add(AssassinLastNameTxt);
                            
                            if(selectedCharacterClass.isEmpty())
                            {
                                selectedCharacterClass.add(thisIsAssassin);
                            }
                            
                            System.out.print("\""+AssassinFirstNameTxt+" "+
                            AssassinLastNameTxt+"\" the Assassin has been"+
                            " loaded from the "+userSaveFile+".txt file.\nPress"+
                            " enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                        }
                        
                        else
                        {
                            selectedCharacter.clear();
                            selectedCharacter.add(AssassinFirstNameTxt);
                            selectedCharacter.add(AssassinLastNameTxt);
                            selectedCharacterClass.clear();
                            selectedCharacterClass.add(thisIsAssassin);
                            System.out.print("\""+AssassinFirstNameTxt+" "+
                            AssassinLastNameTxt+"\" the Assassin has been"+
                            " loaded from the "+userSaveFile+".txt file.\nPress"+
                            " enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                        }
                    }
                    
                    /*if the saved character of the user's save file is of the
                    Engineer Class*/
                    else if(characterClass.contains("Engineer Class"))
                    {
                        /*Read the contents of a saved characters from a user named
                        save file and write it back to that character's respective
                        class files found in the "src" folder*/
                        File EngineerTxtFile = 
                                new File("src/SavedCharacters/"+userSaveFile+".txt");
                        Scanner scanEngineerClassTxtFile = 
                                new Scanner(EngineerTxtFile);
                    
                        /*this variable below is reading the same thing as
                        characterClass and is only needed to read that same line
                        again*/
                        String dontUseThisVariable = 
                                scanEngineerClassTxtFile.nextLine();
                    
                        String EngineerFirstNameTxt = 
                                scanEngineerClassTxtFile.next();
                    
                        String EngineerLastNameTxt = 
                                scanEngineerClassTxtFile.next();
                    
                        String EngineerAccuracyStatValue = 
                                scanEngineerClassTxtFile.next();
                    
                        String EngineerAttackStatValue = 
                                scanEngineerClassTxtFile.next();
                    
                        String EngineerDamageStatValue = 
                                scanEngineerClassTxtFile.next();
                    
                        String EngineerPhyDefStatValue = 
                                scanEngineerClassTxtFile.next();
                    
                        String EngineerMagDefStatValue = 
                                scanEngineerClassTxtFile.next();
                        
                        /*write the Engineer's first name from the user created
                        txt file to the EngineerFirstName.txt file*/
                        try
                        {
                        
                            FileWriter EngineerFirstNameWrite = 
                                    new FileWriter("src/EngineerFirstName.txt");
                            EngineerFirstNameWrite.write(EngineerFirstNameTxt);
                            EngineerFirstNameWrite.close();
                        }
                    
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Engineer's last name from the user created
                        txt file to the EngineerLastName.txt file*/
                        try
                        {
                            FileWriter EngineerLastNameWrite = 
                                    new FileWriter("src/EngineerLastName.txt");
                            EngineerLastNameWrite.write(EngineerLastNameTxt);
                            EngineerLastNameWrite.close();
                        }
                    
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Engineer's Accuracy Stat value*/
                        try
                        {
                            FileWriter EngineerAccuracyStatWrite = 
                                    new FileWriter("src/EngineerAccuracyStat.txt");
                            EngineerAccuracyStatWrite.
                                    write(EngineerAccuracyStatValue);
                            EngineerAccuracyStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Engineer's Attack Stat value*/
                        try
                        {
                            FileWriter EngineerAttackStatWrite = 
                                    new FileWriter("src/EngineerAttackStat.txt");
                            EngineerAttackStatWrite.
                                    write(EngineerAttackStatValue);
                            EngineerAttackStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Engineer's Damage Stat value*/
                        try
                        {
                            FileWriter EngineerDamageStatWrite = 
                                    new FileWriter("src/EngineerDamageStat.txt");
                            EngineerDamageStatWrite.write(EngineerDamageStatValue);
                            EngineerDamageStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Engineer's Physical Defense Stat value*/
                        try
                        {
                            FileWriter EngineerPhyDefStatWrite = 
                                    new FileWriter("src/EngineerPhyDefStat.txt");
                            EngineerPhyDefStatWrite.write(EngineerPhyDefStatValue);
                            EngineerPhyDefStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Engineer's Magical Defense Stat value*/
                        try
                        {
                            FileWriter EngineerMagDefStatWrite = 
                                    new FileWriter("src/EngineerMagDefStat.txt");
                            EngineerMagDefStatWrite.write(EngineerMagDefStatValue);
                            EngineerMagDefStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*make the Engineer from the user-created txt file
                        become the currently selected character*/
                        if(selectedCharacter.isEmpty())
                        {
                            selectedCharacter.add(EngineerFirstNameTxt);
                            selectedCharacter.add(EngineerLastNameTxt);
                            
                            if(selectedCharacterClass.isEmpty())
                            {
                                selectedCharacterClass.add(thisIsEngineer);
                            }
                            
                            System.out.print("\""+EngineerFirstNameTxt+" "+
                            EngineerLastNameTxt+"\" the Engineer has been"+
                            " loaded from the "+userSaveFile+".txt file.\nPress"+
                            " enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                        }
                        
                        else
                        {
                            selectedCharacter.clear();
                            selectedCharacter.add(EngineerFirstNameTxt);
                            selectedCharacter.add(EngineerLastNameTxt);
                            selectedCharacterClass.clear();
                            selectedCharacterClass.add(thisIsEngineer);
                            System.out.print("\""+EngineerFirstNameTxt+" "+
                            EngineerLastNameTxt+"\" the Engineer has been"+
                            " loaded from the "+userSaveFile+".txt file.\nPress"+
                            " enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                        }
                    }
                    
                    /*if the saved character of the user's save file is of the
                    Healer Class*/
                    else if(characterClass.contains("Healer Class"))
                    {
                        /*Read the contents of a saved characters from a user named
                        save file and write it back to that character's respective
                        class files found in the "src" folder*/
                        File HealerTxtFile = 
                                new File("src/SavedCharacters/"+userSaveFile+".txt");
                        Scanner scanHealerClassTxtFile = 
                                new Scanner(HealerTxtFile);
                    
                        /*this variable below is reading the same thing as
                        characterClass and is only needed to read that same line
                        again*/
                        String dontUseThisVariable = 
                                scanHealerClassTxtFile.nextLine();
                    
                        String HealerFirstNameTxt = 
                                scanHealerClassTxtFile.next();
                    
                        String HealerLastNameTxt = 
                                scanHealerClassTxtFile.next();
                    
                        String HealerAccuracyStatValue = 
                                scanHealerClassTxtFile.next();
                    
                        String HealerAttackStatValue = 
                                scanHealerClassTxtFile.next();
                    
                        String HealerDamageStatValue = 
                                scanHealerClassTxtFile.next();
                    
                        String HealerPhyDefStatValue = 
                                scanHealerClassTxtFile.next();
                    
                        String HealerMagDefStatValue = 
                                scanHealerClassTxtFile.next();
                        
                        /*write the Healer's first name from the user created
                        txt file to the HealerFirstName.txt file*/
                        try
                        {
                        
                            FileWriter HealerFirstNameWrite = 
                                    new FileWriter("src/HealerFirstName.txt");
                            HealerFirstNameWrite.write(HealerFirstNameTxt);
                            HealerFirstNameWrite.close();
                        }
                    
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Healer's last name from the user created
                        txt file to the HealerLastName.txt file*/
                        try
                        {
                            FileWriter HealerLastNameWrite = 
                                    new FileWriter("src/HealerLastName.txt");
                            HealerLastNameWrite.write(HealerLastNameTxt);
                            HealerLastNameWrite.close();
                        }
                    
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Healer's Accuracy Stat value*/
                        try
                        {
                            FileWriter HealerAccuracyStatWrite = 
                                    new FileWriter("src/HealerAccuracyStat.txt");
                            HealerAccuracyStatWrite.write(HealerAccuracyStatValue);
                            HealerAccuracyStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Healer's Attack Stat value*/
                        try
                        {
                            FileWriter HealerAttackStatWrite = 
                                    new FileWriter("src/HealerAttackStat.txt");
                            HealerAttackStatWrite.write(HealerAttackStatValue);
                            HealerAttackStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Healer's Damage Stat value*/
                        try
                        {
                            FileWriter HealerDamageStatWrite = 
                                    new FileWriter("src/HealerDamageStat.txt");
                            HealerDamageStatWrite.write(HealerDamageStatValue);
                            HealerDamageStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Healer's Physical Defense Stat value*/
                        try
                        {
                            FileWriter HealerPhyDefStatWrite = 
                                    new FileWriter("src/HealerPhyDefStat.txt");
                            HealerPhyDefStatWrite.write(HealerPhyDefStatValue);
                            HealerPhyDefStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Healer's Magical Defense Stat value*/
                        try
                        {
                            FileWriter HealerMagDefStatWrite = 
                                    new FileWriter("src/HealerMagDefStat.txt");
                            HealerMagDefStatWrite.write(HealerMagDefStatValue);
                            HealerMagDefStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*make the Healer from the user-created txt file
                        become the currently selected character*/
                        if(selectedCharacter.isEmpty())
                        {
                            selectedCharacter.add(HealerFirstNameTxt);
                            selectedCharacter.add(HealerLastNameTxt);
                            
                            if(selectedCharacterClass.isEmpty())
                            {
                                selectedCharacterClass.add(thisIsHealer);
                            }
                            
                            System.out.print("\""+HealerFirstNameTxt+" "+
                            HealerLastNameTxt+"\" the Healer has been"+
                            " loaded from the "+userSaveFile+".txt file.\nPress"+
                            " enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                        }
                        
                        else
                        {
                            selectedCharacter.clear();
                            selectedCharacter.add(HealerFirstNameTxt);
                            selectedCharacter.add(HealerLastNameTxt);
                            selectedCharacterClass.clear();
                            selectedCharacterClass.add(thisIsHealer);
                            System.out.print("\""+HealerFirstNameTxt+" "+
                            HealerLastNameTxt+"\" the Healer has been"+
                            " loaded from the "+userSaveFile+".txt file.\nPress"+
                            " enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                        }
                    }
                    
                    /*if the saved character of the user's save file is of the
                    Martial Artist Class*/
                    else if(characterClass.contains("Martial Artist Class"))
                    {
                        /*Read the contents of a saved characters from a user named
                        save file and write it back to that character's respective
                        class files found in the "src" folder*/
                        File MartialArtistTxtFile = 
                                new File("src/SavedCharacters/"+userSaveFile+".txt");
                        Scanner scanMartialArtistClassTxtFile = 
                                new Scanner(MartialArtistTxtFile);
                    
                        /*this variable below is reading the same thing as
                        characterClass and is only needed to read that same line
                        again*/
                        String dontUseThisVariable = 
                                scanMartialArtistClassTxtFile.nextLine();
                    
                        String MartialArtistFirstNameTxt = 
                                scanMartialArtistClassTxtFile.next();
                    
                        String MartialArtistLastNameTxt = 
                                scanMartialArtistClassTxtFile.next();
                    
                        String MartialArtistAccuracyStatValue = 
                                scanMartialArtistClassTxtFile.next();
                    
                        String MartialArtistAttackStatValue = 
                                scanMartialArtistClassTxtFile.next();
                    
                        String MartialArtistDamageStatValue = 
                                scanMartialArtistClassTxtFile.next();
                    
                        String MartialArtistPhyDefStatValue = 
                                scanMartialArtistClassTxtFile.next();
                    
                        String MartialArtistMagDefStatValue = 
                                scanMartialArtistClassTxtFile.next();
                        
                        /*write the Martial Artist's first name from the user created
                        txt file to the HealerFirstName.txt file*/
                        try
                        {
                        
                            FileWriter MartialArtistFirstNameWrite = 
                                    new FileWriter("src/MartialArtistFirstName.txt");
                            MartialArtistFirstNameWrite.write(MartialArtistFirstNameTxt);
                            MartialArtistFirstNameWrite.close();
                        }
                    
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Martial Artist's last name from the user created
                        txt file to the MartialArtistLastName.txt file*/
                        try
                        {
                            FileWriter MartialArtistLastNameWrite = 
                                    new FileWriter("src/MartialArtistLastName.txt");
                            MartialArtistLastNameWrite.
                                    write(MartialArtistLastNameTxt);
                            MartialArtistLastNameWrite.close();
                        }
                    
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Martial Artist's Accuracy Stat value*/
                        try
                        {
                            FileWriter MartialArtistAccuracyStatWrite = 
                                    new FileWriter("src/MartialArtistAccuracyStat.txt");
                            MartialArtistAccuracyStatWrite.
                                    write(MartialArtistAccuracyStatValue);
                            MartialArtistAccuracyStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Martial Artist's Attack Stat value*/
                        try
                        {
                            FileWriter MartialArtistAttackStatWrite = 
                                    new FileWriter
                                    ("src/MartialArtistAttackStat.txt");
                            MartialArtistAttackStatWrite.
                                    write(MartialArtistAttackStatValue);
                            MartialArtistAttackStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Martial Artist's Damage Stat value*/
                        try
                        {
                            FileWriter MartialArtistDamageStatWrite = 
                                    new FileWriter
                                        ("src/MartialArtistDamageStat.txt");
                            MartialArtistDamageStatWrite.
                                    write(MartialArtistDamageStatValue);
                            MartialArtistDamageStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Martial Artist's Physical Defense Stat value*/
                        try
                        {
                            FileWriter MartialArtistPhyDefStatWrite = 
                                    new FileWriter
                                        ("src/MartialArtistPhyDefStat.txt");
                            MartialArtistPhyDefStatWrite.
                                    write(MartialArtistPhyDefStatValue);
                            MartialArtistPhyDefStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Martial Artist's Magical Defense Stat value*/
                        try
                        {
                            FileWriter MartialArtistMagDefStatWrite = 
                                    new FileWriter
                                        ("src/MartialArtistMagDefStat.txt");
                            MartialArtistMagDefStatWrite.
                                    write(MartialArtistMagDefStatValue);
                            MartialArtistMagDefStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*make the Martial Artist from the user-created txt file
                        become the currently selected character*/
                        if(selectedCharacter.isEmpty())
                        {
                            selectedCharacter.add(MartialArtistFirstNameTxt);
                            selectedCharacter.add(MartialArtistLastNameTxt);
                            
                            if(selectedCharacterClass.isEmpty())
                            {
                                selectedCharacterClass.add(thisIsMartialArtist);
                            }
                            
                            System.out.print("\""+MartialArtistFirstNameTxt+" "+
                            MartialArtistLastNameTxt+"\" the Martial Artist has been"+
                            " loaded from the "+userSaveFile+".txt file.\nPress"+
                            " enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                        }
                        
                        else
                        {
                            selectedCharacter.clear();
                            selectedCharacter.add(MartialArtistFirstNameTxt);
                            selectedCharacter.add(MartialArtistLastNameTxt);
                            selectedCharacterClass.clear();
                            selectedCharacterClass.add(thisIsMartialArtist);
                            System.out.print("\""+MartialArtistFirstNameTxt+" "+
                            MartialArtistLastNameTxt+"\" the Martial Artist has been"+
                            " loaded from the "+userSaveFile+".txt file.\nPress"+
                            " enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                        }
                    }
                    
                    /*if the saved character of the user's save file is of the
                    Necromancer Class*/
                    else if(characterClass.contains("Necromancer Class"))
                    {
                        /*Read the contents of a saved characters from a user named
                        save file and write it back to that character's respective
                        class files found in the "src" folder*/
                        File NecromancerTxtFile = 
                                new File
                                    ("src/SavedCharacters/"+userSaveFile+".txt");
                        Scanner scanNecromancerClassTxtFile = 
                                new Scanner(NecromancerTxtFile);
                    
                        /*this variable below is reading the same thing as
                        characterClass and is only needed to read that same line
                        again*/
                        String dontUseThisVariable = 
                                scanNecromancerClassTxtFile.nextLine();
                    
                        String NecromancerFirstNameTxt = 
                                scanNecromancerClassTxtFile.next();
                    
                        String NecromancerLastNameTxt = 
                                scanNecromancerClassTxtFile.next();
                    
                        String NecromancerAccuracyStatValue = 
                                scanNecromancerClassTxtFile.next();
                    
                        String NecromancerAttackStatValue = 
                                scanNecromancerClassTxtFile.next();
                    
                        String NecromancerDamageStatValue = 
                                scanNecromancerClassTxtFile.next();
                    
                        String NecromancerPhyDefStatValue = 
                                scanNecromancerClassTxtFile.next();
                    
                        String NecromancerMagDefStatValue = 
                                scanNecromancerClassTxtFile.next();
                        
                        /*write the Necromancer's first name from the user created
                        txt file to the NecromancerFirstName.txt file*/
                        try
                        {
                        
                            FileWriter NecromancerFirstNameWrite = 
                                    new FileWriter("src/NecromancerFirstName.txt");
                            NecromancerFirstNameWrite.
                                    write(NecromancerFirstNameTxt);
                            NecromancerFirstNameWrite.close();
                        }
                    
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Necromancer's last name from the user created
                        txt file to the NecromancerLastName.txt file*/
                        try
                        {
                            FileWriter NecromancerLastNameWrite = 
                                    new FileWriter("src/NecromancerLastName.txt");
                            NecromancerLastNameWrite.write(NecromancerLastNameTxt);
                            NecromancerLastNameWrite.close();
                        }
                    
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Necromancer's Accuracy Stat value*/
                        try
                        {
                            FileWriter NecromancerAccuracyStatWrite = 
                                    new FileWriter("src/NecromancerAccuracyStat.txt");
                            NecromancerAccuracyStatWrite.
                                    write(NecromancerAccuracyStatValue);
                            NecromancerAccuracyStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Necromancer's Attack Stat value*/
                        try
                        {
                            FileWriter NecromancerAttackStatWrite = 
                                    new FileWriter
                                        ("src/NecromancerAttackStat.txt");
                            NecromancerAttackStatWrite.
                                    write(NecromancerAttackStatValue);
                            NecromancerAttackStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Necromancer's Damage Stat value*/
                        try
                        {
                            FileWriter NecromancerDamageStatWrite = 
                                    new FileWriter
                                        ("src/NecromancerDamageStat.txt");
                            NecromancerDamageStatWrite.
                                    write(NecromancerDamageStatValue);
                            NecromancerDamageStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Necromancer's Physical Defense Stat value*/
                        try
                        {
                            FileWriter NecromancerPhyDefStatWrite = 
                                    new FileWriter("src/NecromancerPhyDefStat.txt");
                            NecromancerPhyDefStatWrite.
                                    write(NecromancerPhyDefStatValue);
                            NecromancerPhyDefStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Necromancer's Magical Defense Stat value*/
                        try
                        {
                            FileWriter NecromancerMagDefStatWrite = 
                                    new FileWriter("src/NecromancerMagDefStat.txt");
                            NecromancerMagDefStatWrite.
                                    write(NecromancerMagDefStatValue);
                            NecromancerMagDefStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*make the Necromancer from the user-created txt file
                        become the currently selected character*/
                        if(selectedCharacter.isEmpty())
                        {
                            selectedCharacter.add(NecromancerFirstNameTxt);
                            selectedCharacter.add(NecromancerLastNameTxt);
                            
                            if(selectedCharacterClass.isEmpty())
                            {
                                selectedCharacterClass.add(thisIsNecromancer);
                            }
                            
                            System.out.print("\""+NecromancerFirstNameTxt+" "+
                            NecromancerLastNameTxt+"\" the Necromancer has been"+
                            " loaded from the "+userSaveFile+".txt file.\nPress"+
                            " enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                        }
                        
                        else
                        {
                            selectedCharacter.clear();
                            selectedCharacter.add(NecromancerFirstNameTxt);
                            selectedCharacter.add(NecromancerLastNameTxt);
                            selectedCharacterClass.clear();
                            selectedCharacterClass.add(thisIsNecromancer);
                            System.out.print("\""+NecromancerFirstNameTxt+" "+
                            NecromancerLastNameTxt+"\" the Necromancer has been"+
                            " loaded from the "+userSaveFile+".txt file.\nPress"+
                            " enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                        }
                    }
                    
                    /*if the saved character of the user's save file is of the
                    Wizard Class*/
                    else if(characterClass.contains("Wizard Class"))
                    {
                        /*Read the contents of a saved characters from a user named
                        save file and write it back to that character's respective
                        class files found in the "src" folder*/
                        File WizardTxtFile = 
                                new File
                                    ("src/SavedCharacters/"+userSaveFile+".txt");
                        Scanner scanWizardClassTxtFile = 
                                new Scanner(WizardTxtFile);
                    
                        /*this variable below is reading the same thing as
                        characterClass and is only needed to read that same line
                        again*/
                        String dontUseThisVariable = 
                                scanWizardClassTxtFile.nextLine();
                    
                        String WizardFirstNameTxt = 
                                scanWizardClassTxtFile.next();
                    
                        String WizardLastNameTxt = 
                                scanWizardClassTxtFile.next();
                    
                        String WizardAccuracyStatValue = 
                                scanWizardClassTxtFile.next();
                    
                        String WizardAttackStatValue = 
                                scanWizardClassTxtFile.next();
                    
                        String WizardDamageStatValue = 
                                scanWizardClassTxtFile.next();
                    
                        String WizardPhyDefStatValue = 
                                scanWizardClassTxtFile.next();
                    
                        String WizardMagDefStatValue = 
                                scanWizardClassTxtFile.next();
                        
                        /*write the Wizard's first name from the user created
                        txt file to the WizardFirstName.txt file*/
                        try
                        {
                        
                            FileWriter WizardFirstNameWrite = 
                                    new FileWriter("src/WizardFirstName.txt");
                            WizardFirstNameWrite.
                                    write(WizardFirstNameTxt);
                            WizardFirstNameWrite.close();
                        }
                    
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Wizard's last name from the user created
                        txt file to the WizardLastName.txt file*/
                        try
                        {
                            FileWriter WizardLastNameWrite = 
                                    new FileWriter("src/WizardLastName.txt");
                            WizardLastNameWrite.write(WizardLastNameTxt);
                            WizardLastNameWrite.close();
                        }
                    
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Wizard's Accuracy Stat value*/
                        try
                        {
                            FileWriter WizardAccuracyStatWrite = 
                                    new FileWriter("src/WizardAccuracyStat.txt");
                            WizardAccuracyStatWrite.
                                    write(WizardAccuracyStatValue);
                            WizardAccuracyStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Wizard's Attack Stat value*/
                        try
                        {
                            FileWriter WizardAttackStatWrite = 
                                    new FileWriter("src/WizardAttackStat.txt");
                            WizardAttackStatWrite.write(WizardAttackStatValue);
                            WizardAttackStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Wizard's Damage Stat value*/
                        try
                        {
                            FileWriter WizardDamageStatWrite = 
                                    new FileWriter("src/WizardDamageStat.txt");
                            WizardDamageStatWrite.write(WizardDamageStatValue);
                            WizardDamageStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Wizard's Physical Defense Stat value*/
                        try
                        {
                            FileWriter WizardPhyDefStatWrite = 
                                    new FileWriter("src/WizardPhyDefStat.txt");
                            WizardPhyDefStatWrite.write(WizardPhyDefStatValue);
                            WizardPhyDefStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*write the Wizard's Magical Defense Stat value*/
                        try
                        {
                            FileWriter WizardMagDefStatWrite = 
                                    new FileWriter("src/WizardMagDefStat.txt");
                            WizardMagDefStatWrite.write(WizardMagDefStatValue);
                            WizardMagDefStatWrite.close();
                        }
                        
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        /*make the Wizard from the user-created txt file
                        become the currently selected character*/
                        if(selectedCharacter.isEmpty())
                        {
                            selectedCharacter.add(WizardFirstNameTxt);
                            selectedCharacter.add(WizardLastNameTxt);
                            
                            if(selectedCharacterClass.isEmpty())
                            {
                                selectedCharacterClass.add(thisIsWizard);
                            }
                            
                            System.out.print("\""+WizardFirstNameTxt+" "+
                            WizardLastNameTxt+"\" the Wizard has been"+
                            " loaded from the "+userSaveFile+".txt file.\nPress"+
                            " enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                        }
                        
                        else
                        {
                            selectedCharacter.clear();
                            selectedCharacter.add(WizardFirstNameTxt);
                            selectedCharacter.add(WizardLastNameTxt);
                            selectedCharacterClass.clear();
                            selectedCharacterClass.add(thisIsWizard);
                            System.out.print("\""+WizardFirstNameTxt+" "+
                            WizardLastNameTxt+"\" the Wizard has been"+
                            " loaded from the "+userSaveFile+".txt file.\nPress"+
                            " enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                        }
                    }  
                }
                
                /*if the user's file they try to load does not exist, or if they
                typed it in wrong*/
                catch(FileNotFoundException e)
                {
                    System.out.print("Either that file does not exist, or you"+
                    " need to be sure that you did not type\nin the name of"+
                    " your"+
                    " file incorrectly. Press enter to continue.");
                    try{System.in.read();}
                    catch(Exception exception){}
                    System.out.println();
                    System.out.println();
                }
            }
            
            else if(userMainMenu == 4)
            {
                System.out.println("Save a character to file");
                System.out.println("---------------------------");
                if(selectedCharacterClass.isEmpty())
                {
                    System.out.print("You must either create a character"+
                            " or select"+
                    " an existing character\nbefore you can save them"
                            + " to a file. Press enter"+
                    " to continue.");
                    try{System.in.read();}
                    catch(Exception e){}
                    System.out.println();
                    System.out.println();
                }
                
                //if the character being saved is of the Assassin Class
                if(selectedCharacterClass.contains(thisIsAssassin))
                {
                    //will retrieve AssassinFirstName.txt
                    File Assassin1stFile = new File("src/AssassinFirstName.txt");
                    Scanner scanAssassinFirstName = new Scanner(Assassin1stFile);
                
                    //will retrieve AssassinLastName.txt
                    File Assassin2ndFile = new File("src/AssassinLastName.txt");
                    Scanner scanAssassinLastName = new Scanner(Assassin2ndFile);
                
                    //read the AssassinFirstName.txt file & AssassinLastName.txt file
                    String AssassinFirstNameTxt = scanAssassinFirstName.next();
                    String AssassinLastNameTxt = scanAssassinLastName.next();
                   
                    String userSave;
                    System.out.print("Are you sure you want to save your"+
                    " currently selected character: \""+AssassinFirstNameTxt+" "+
                            AssassinLastNameTxt+"\" the Assassin?\nIf yes enter y"+
                            ", or if no enter n: ");
                    userSave = scan.next();
                    System.out.println();
                    if(userSave.equals("y") || userSave.equals("Y"))
                    {
                        /*retrieve all Assassin Files: Name and Stat files*/
                        //------------------------------------------------------
                        
                        //retrieve AssassinFirstName.txt
                        File AssassinFirstNameTxt2 = 
                                new File("src/AssassinFirstName.txt");
                        Scanner scanAssassinFirstNameTxt = 
                                new Scanner(AssassinFirstNameTxt2);
                        //read the AssassinFirstName.txt file
                        String AssassinFirstName2 = 
                                scanAssassinFirstNameTxt.next();
                        
                        //retrieve AssassinLastName.txt
                        File AssassinLastNameTxt2 = 
                                new File("src/AssassinLastName.txt");
                        Scanner scanAssassinLastNameTxt = 
                                new Scanner(AssassinLastNameTxt2);
                        //read the AssassinLastName.txt file
                        String AssassinLastName2 = scanAssassinLastNameTxt.next();
                        
                        //retrieve AssassinAccuracyStat.txt
                        File AssassinAccuracyStatTxt = 
                                new File("src/AssassinAccuracyStat.txt");
                        Scanner scanAssassinAccuracyStatTxt = 
                                new Scanner(AssassinAccuracyStatTxt);
                        //read the AssassinAccuracyStat.txt file
                        String AssassinAccuracyStat = 
                                scanAssassinAccuracyStatTxt.next();
                        
                        //retrieve AssassinAttackStat.txt
                        File AssassinAttackStatTxt = 
                                new File("src/AssassinAttackStat.txt");
                        Scanner scanAssassinAttackStatTxt = 
                                new Scanner(AssassinAttackStatTxt);
                        //read the AssassinAttackStat.txt file 
                        String AssassinAttackStat = scanAssassinAttackStatTxt.next();
                        
                        //retrieve AssassinDamageStat.txt
                        File AssassinDamageStatTxt = 
                                new File("src/AssassinDamageStat.txt");
                        Scanner scanAssassinDamageStatTxt = 
                                new Scanner(AssassinDamageStatTxt);
                        //read the AssassinDamageStat.txt file
                        String AssassinDamageStat = 
                                scanAssassinDamageStatTxt.next();
                        
                        //retrieve AssassinPhyDefStat.txt
                        File AssassinPhyDefStatTxt = 
                                new File("src/AssassinPhyDefStat.txt");
                        Scanner scanAssassinPhyDefStatTxt = 
                                new Scanner(AssassinPhyDefStatTxt);
                        //read the AssassinPhyDefStat.txt file
                        String AssassinPhyDefStat = 
                                scanAssassinPhyDefStatTxt.next();
                        
                        //retrieve AssassinMagDefStat.txt
                        File AssassinMagDefStatTxt = 
                                new File("src/AssassinMagDefStat.txt");
                        Scanner scanAssassinMagDefStatTxt = 
                                new Scanner(AssassinMagDefStatTxt);
                        //read the AssassinMagDefStat.txt file
                        String AssassinMagDefStat = 
                                scanAssassinMagDefStatTxt.next();
                        
                        try
                        {
                            System.out.print("Enter the name of your save file"+
                            " (be sure to not overwrite any other save files"+
                            " you have\nby using the same save file name more"+
                            " than once): ");
                            userNamedSaveFile = scan.next();
                            System.out.println();
                            
                            FileWriter writeUserSave = 
                                    new FileWriter("src/SavedCharacters/"+
                                    userNamedSaveFile+".txt");
                            
                            /*Write "Assassin Class" to the character's user created
                            save file so that it can later be read when the user
                            loads their file to load their character so that the
                            character's class can be determined as "Assassin"
                            upon the load of the character in the userMainMenu #3
                            option.*/
                            writeUserSave.write("Assassin Class"+"\n"+
                            AssassinFirstName2+"\n"+AssassinLastName2+"\n"+
                            AssassinAccuracyStat+"\n"+AssassinAttackStat+"\n"+
                            AssassinDamageStat+"\n"+AssassinPhyDefStat+"\n"+
                            AssassinMagDefStat);
                            writeUserSave.close();
                            System.out.print("\""+AssassinFirstName2+' '+
                            AssassinLastName2+"\" the Assassin has been saved"+
                            " to the "+userNamedSaveFile+".txt file.\nPress"+
                            " enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                            
                        }
               
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                    }
                    
                    else if(userSave.equals("n") || userSave.equals("N"))
                    {
                        System.out.print("Ok, no characters will be saved to"+
                        " any files. Press enter to continue.");
                        try{System.in.read();}
                        catch(Exception e){}
                        System.out.println();
                        System.out.println();
                    }
                    
                    else
                    {
                        System.out.print("You must enter \"y\" to save"+
                        " a character or \"n\" to not do so, please try"+
                        " again. Press enter to continue.");
                        try{System.in.read();}
                        catch(Exception e){}
                        System.out.println();
                        System.out.println();
                    }
                    
                }
                
                //if the character being saved is of the Engineer Class
                if(selectedCharacterClass.contains(thisIsEngineer))
                {
                    //will retrieve EngineerFirstName.txt
                    File Engineer1stFile = new File("src/EngineerFirstName.txt");
                    Scanner scanEngineerFirstName = new Scanner(Engineer1stFile);
                
                    //will retrieve EngineerLastName.txt
                    File Engineer2ndFile = new File("src/EngineerLastName.txt");
                    Scanner scanEngineerLastName = new Scanner(Engineer2ndFile);
                
                    //read the EngineerFirstName.txt file & EngineerLastName.txt file
                    String EngineerFirstNameTxt = scanEngineerFirstName.next();
                    String EngineerLastNameTxt = scanEngineerLastName.next();
                    
                    String userSave;
                    System.out.print("Are you sure you want to save your"+
                    " currently selected character: \""+EngineerFirstNameTxt+" "+
                            EngineerLastNameTxt+"\" the Engineer?\nIf yes enter y"+
                            ", or if no enter n: ");
                    userSave = scan.next();
                    System.out.println();
                    if(userSave.equals("y") || userSave.equals("Y"))
                    {
                        /*retrieve all Engineer Files: Name and Stat files*/
                        //------------------------------------------------------
                        
                        //retrieve EngineerFirstName.txt
                        File EngineerFirstNameTxt2 = 
                                new File("src/EngineerFirstName.txt");
                        Scanner scanEngineerFirstNameTxt = 
                                new Scanner(EngineerFirstNameTxt2);
                        //read the EngineerFirstName.txt file
                        String EngineerFirstName2 = 
                                scanEngineerFirstNameTxt.next();
                        
                        //retrieve EngineerLastName.txt
                        File EngineerLastNameTxt2 = 
                                new File("src/EngineerLastName.txt");
                        Scanner scanEngineerLastNameTxt = 
                                new Scanner(EngineerLastNameTxt2);
                        //read the EngineerLastName.txt file
                        String EngineerLastName2 = scanEngineerLastNameTxt.next();
                        
                        //retrieve EngineerAccuracyStat.txt
                        File EngineerAccuracyStatTxt = 
                                new File("src/EngineerAccuracyStat.txt");
                        Scanner scanEngineerAccuracyStatTxt = 
                                new Scanner(EngineerAccuracyStatTxt);
                        //read the EngineerAccuracyStat.txt file
                        String EngineerAccuracyStat = 
                                scanEngineerAccuracyStatTxt.next();
                        
                        //retrieve EngineerAttackStat.txt
                        File EngineerAttackStatTxt = 
                                new File("src/EngineerAttackStat.txt");
                        Scanner scanEngineerAttackStatTxt = 
                                new Scanner(EngineerAttackStatTxt);
                        //read the EngineerAttackStat.txt file 
                        String EngineerAttackStat = 
                                scanEngineerAttackStatTxt.next();
                        
                        //retrieve EngineerDamageStat.txt
                        File EngineerDamageStatTxt = 
                                new File("src/EngineerDamageStat.txt");
                        Scanner scanEngineerDamageStatTxt = 
                                new Scanner(EngineerDamageStatTxt);
                        //read the EngineerDamageStat.txt file
                        String EngineerDamageStat = 
                                scanEngineerDamageStatTxt.next();
                        
                        //retrieve EngineerPhyDefStat.txt
                        File EngineerPhyDefStatTxt = 
                                new File("src/EngineerPhyDefStat.txt");
                        Scanner scanEngineerPhyDefStatTxt = 
                                new Scanner(EngineerPhyDefStatTxt);
                        //read the EngineerPhyDefStat.txt file
                        String EngineerPhyDefStat = 
                                scanEngineerPhyDefStatTxt.next();
                        
                        //retrieve EngineerMagDefStat.txt
                        File EngineerMagDefStatTxt = 
                                new File("src/EngineerMagDefStat.txt");
                        Scanner scanEngineerMagDefStatTxt = 
                                new Scanner(EngineerMagDefStatTxt);
                        //read the EngineerMagDefStat.txt file
                        String EngineerMagDefStat = 
                                scanEngineerMagDefStatTxt.next();
                        
                        try
                        {
                            System.out.print("Enter the name of your save file"+
                            " (be sure to not overwrite any other save files"+
                            " you have\nby using the same save file name more"+
                            " than once): ");
                            userNamedSaveFile = scan.next();
                            System.out.println();
                            
                            FileWriter writeUserSave = 
                                    new FileWriter
                               ("src/SavedCharacters/"+userNamedSaveFile+".txt");
                            
                            /*Write "Engineer Class" to the character's user created
                            save file so that it can later be read when the user
                            loads their file to load their character so that the
                            character's class can be determined as "Engineer"
                            upon the load of the character in the userMainMenu #3
                            option.*/
                            writeUserSave.write("Engineer Class"+"\n"+
                            EngineerFirstName2+"\n"+EngineerLastName2+"\n"+
                            EngineerAccuracyStat+"\n"+EngineerAttackStat+"\n"+
                            EngineerDamageStat+"\n"+EngineerPhyDefStat+"\n"+
                            EngineerMagDefStat);
                            writeUserSave.close();
                            System.out.print("\""+EngineerFirstName2+' '+
                            EngineerLastName2+"\" the Engineer has been saved"+
                            " to the "+userNamedSaveFile+".txt file.\nPress"+
                            " enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                            
                        }
               
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                    }
                    
                    else if(userSave.equals("n") || userSave.equals("N"))
                    {
                        System.out.print("Ok, no characters will be saved to"+
                        " any files. Press enter to continue.");
                        try{System.in.read();}
                        catch(Exception e){}
                        System.out.println();
                        System.out.println();
                    }
                    
                    else
                    {
                        System.out.print("You must enter \"y\" to save"+
                        " a character or \"n\" to not do so, please try"+
                        " again. Press enter to continue.");
                        try{System.in.read();}
                        catch(Exception e){}
                        System.out.println();
                        System.out.println();
                    }
                    
                }
                
                //if the character being saved is of the Healer Class
                if(selectedCharacterClass.contains(thisIsHealer))
                {
                    //will retrieve HealerFirstName.txt
                    File Healer1stFile = new File("src/HealerFirstName.txt");
                    Scanner scanHealerFirstName = new Scanner(Healer1stFile);
                
                    //will retrieve HealerLastName.txt
                    File Healer2ndFile = new File("src/HealerLastName.txt");
                    Scanner scanHealerLastName = new Scanner(Healer2ndFile);
                
                    //read the HealerFirstName.txt file & HealerLastName.txt file
                    String HealerFirstNameTxt = scanHealerFirstName.next();
                    String HealerLastNameTxt = scanHealerLastName.next();
                    
                    String userSave;
                    System.out.print("Are you sure you want to save your"+
                    " currently selected character: \""+HealerFirstNameTxt+" "+
                            HealerLastNameTxt+"\" the Healer?\nIf yes enter y"+
                            ", or if no enter n: ");
                    userSave = scan.next();
                    System.out.println();
                    if(userSave.equals("y") || userSave.equals("Y"))
                    {
                        /*retrieve all Healer Files: Name and Stat files*/
                        //------------------------------------------------------
                        
                        //retrieve HealerFirstName.txt
                        File HealerFirstNameTxt2 = 
                                new File("src/HealerFirstName.txt");
                        Scanner scanHealerFirstNameTxt = 
                                new Scanner(HealerFirstNameTxt2);
                        //read the HealerFirstName.txt file
                        String HealerFirstName2 = scanHealerFirstNameTxt.next();
                        
                        //retrieve HealerLastName.txt
                        File HealerLastNameTxt2 = 
                                new File("src/HealerLastName.txt");
                        Scanner scanHealerLastNameTxt = 
                                new Scanner(HealerLastNameTxt2);
                        //read the HealerLastName.txt file
                        String HealerLastName2 = scanHealerLastNameTxt.next();
                        
                        //retrieve HealerAccuracyStat.txt
                        File HealerAccuracyStatTxt = 
                                new File("src/HealerAccuracyStat.txt");
                        Scanner scanHealerAccuracyStatTxt = 
                                new Scanner(HealerAccuracyStatTxt);
                        //read the HealerAccuracyStat.txt file
                        String HealerAccuracyStat = 
                                scanHealerAccuracyStatTxt.next();
                        
                        //retrieve HealerAttackStat.txt
                        File HealerAttackStatTxt = 
                                new File("src/HealerAttackStat.txt");
                        Scanner scanHealerAttackStatTxt = 
                                new Scanner(HealerAttackStatTxt);
                        //read the HealerAttackStat.txt file 
                        String HealerAttackStat = scanHealerAttackStatTxt.next();
                        
                        //retrieve HealerDamageStat.txt
                        File HealerDamageStatTxt = 
                                new File("src/HealerDamageStat.txt");
                        Scanner scanHealerDamageStatTxt = 
                                new Scanner(HealerDamageStatTxt);
                        //read the HealerDamageStat.txt file
                        String HealerDamageStat = scanHealerDamageStatTxt.next();
                        
                        //retrieve HealerPhyDefStat.txt
                        File HealerPhyDefStatTxt = 
                                new File("src/HealerPhyDefStat.txt");
                        Scanner scanHealerPhyDefStatTxt = 
                                new Scanner(HealerPhyDefStatTxt);
                        //read the HealerPhyDefStat.txt file
                        String HealerPhyDefStat = scanHealerPhyDefStatTxt.next();
                        
                        //retrieve HealerMagDefStat.txt
                        File HealerMagDefStatTxt = 
                                new File("src/HealerMagDefStat.txt");
                        Scanner scanHealerMagDefStatTxt = 
                                new Scanner(HealerMagDefStatTxt);
                        //read the HealerMagDefStat.txt file
                        String HealerMagDefStat = scanHealerMagDefStatTxt.next();
                        
                        try
                        {
                            System.out.print("Enter the name of your save file"+
                            " (be sure to not overwrite any other save files"+
                            " you have\nby using the same save file name more"+
                            " than once): ");
                            userNamedSaveFile = scan.next();
                            System.out.println();
                            
                            FileWriter writeUserSave = 
                                    new FileWriter("src/SavedCharacters/"+
                                    userNamedSaveFile+".txt");
                            
                            /*Write "Healer Class" to the character's user created
                            save file so that it can later be read when the user
                            loads their file to load their character so that the
                            character's class can be determined as "Healer"
                            upon the load of the character in the userMainMenu #3
                            option.*/
                            writeUserSave.write("Healer Class"+"\n"+
                            HealerFirstName2+"\n"+HealerLastName2+"\n"+
                            HealerAccuracyStat+"\n"+HealerAttackStat+"\n"+
                            HealerDamageStat+"\n"+HealerPhyDefStat+"\n"+
                            HealerMagDefStat);
                            writeUserSave.close();
                            System.out.print("\""+HealerFirstName2+' '+
                            HealerLastName2+"\" the Healer has been saved"+
                            " to the "+userNamedSaveFile+".txt file.\nPress"+
                            " enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                            
                        }
               
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                    }
                    
                    else if(userSave.equals("n") || userSave.equals("N"))
                    {
                        System.out.print("Ok, no characters will be saved to"+
                        " any files. Press enter to continue.");
                        try{System.in.read();}
                        catch(Exception e){}
                        System.out.println();
                        System.out.println();
                    }
                    
                    else
                    {
                        System.out.print("You must enter \"y\" to save"+
                        " a character or \"n\" to not do so, please try"+
                        " again. Press enter to continue.");
                        try{System.in.read();}
                        catch(Exception e){}
                        System.out.println();
                        System.out.println();
                    }
                    
                }
                
                //if the character being saved is of the Martial Artist Class
                if(selectedCharacterClass.contains(thisIsMartialArtist))
                {
                    //will retrieve MartialArtistFirstName.txt
                    File MartialArtist1stFile = 
                            new File("src/MartialArtistFirstName.txt");
                    Scanner scanMartialArtistFirstName = 
                            new Scanner(MartialArtist1stFile);
                
                    //will retrieve MartialArtistLastName.txt
                    File MartialArtist2ndFile = 
                            new File("src/MartialArtistLastName.txt");
                    Scanner scanMartialArtistLastName = 
                            new Scanner(MartialArtist2ndFile);
                
                    /*read the MartialArtistFirstName.txt file &
                    MartialArtistLastName.txt file*/
                    String MartialArtistFirstNameTxt = 
                            scanMartialArtistFirstName.next();
                    String MartialArtistLastNameTxt = 
                            scanMartialArtistLastName.next();
                    
                    String userSave;
                    System.out.print("Are you sure you want to save your"+
                    " currently selected character: \""+
                            MartialArtistFirstNameTxt+" "+
                            MartialArtistLastNameTxt+
                            "\" the Martial Artist?\nIf yes enter y"+
                            ", or if no enter n: ");
                    userSave = scan.next();
                    System.out.println();
                    if(userSave.equals("y") || userSave.equals("Y"))
                    {
                        /*retrieve all Martial Artist Files: Name and Stat files*/
                        //------------------------------------------------------
                        
                        //retrieve MartialArtistFirstName.txt
                        File MartialArtistFirstNameTxt2 = 
                                new File("src/MartialArtistFirstName.txt");
                        Scanner scanMartialArtistFirstNameTxt = 
                                new Scanner(MartialArtistFirstNameTxt2);
                        //read the MartialArtistFirstName.txt file
                        String MartialArtistFirstName2 = 
                                scanMartialArtistFirstNameTxt.next();
                        
                        //retrieve MartialArtistLastName.txt
                        File MartialArtistLastNameTxt2 = 
                                new File("src/MartialArtistLastName.txt");
                        Scanner scanMartialArtistLastNameTxt = 
                                new Scanner(MartialArtistLastNameTxt2);
                        //read the MartialArtistLastName.txt file
                        String MartialArtistLastName2 = 
                                scanMartialArtistLastNameTxt.next();
                        
                        //retrieve MartialArtistAccuracyStat.txt
                        File MartialArtistAccuracyStatTxt = 
                                new File("src/MartialArtistAccuracyStat.txt");
                        Scanner scanMartialArtistAccuracyStatTxt = 
                                new Scanner(MartialArtistAccuracyStatTxt);
                        //read the MartialArtistAccuracyStat.txt file
                        String MartialArtistAccuracyStat = 
                                scanMartialArtistAccuracyStatTxt.next();
                        
                        //retrieve MartialArtistAttackStat.txt
                        File MartialArtistAttackStatTxt = 
                                new File("src/MartialArtistAttackStat.txt");
                        Scanner scanMartialArtistAttackStatTxt = 
                                new Scanner(MartialArtistAttackStatTxt);
                        //read the MartialArtistAttackStat.txt file 
                        String MartialArtistAttackStat = 
                                scanMartialArtistAttackStatTxt.next();
                        
                        //retrieve MartialArtistDamageStat.txt
                        File MartialArtistDamageStatTxt = 
                                new File("src/MartialArtistDamageStat.txt");
                        Scanner scanMartialArtistDamageStatTxt = 
                                new Scanner(MartialArtistDamageStatTxt);
                        //read the MartialArtistDamageStat.txt file
                        String MartialArtistDamageStat = 
                                scanMartialArtistDamageStatTxt.next();
                        
                        //retrieve MartialArtistPhyDefStat.txt
                        File MartialArtistPhyDefStatTxt = 
                                new File("src/MartialArtistPhyDefStat.txt");
                        Scanner scanMartialArtistPhyDefStatTxt = 
                                new Scanner(MartialArtistPhyDefStatTxt);
                        //read the MartialArtistPhyDefStat.txt file
                        String MartialArtistPhyDefStat = 
                                scanMartialArtistPhyDefStatTxt.next();
                        
                        //retrieve MartialArtistMagDefStat.txt
                        File MartialArtistMagDefStatTxt = 
                                new File("src/MartialArtistMagDefStat.txt");
                        Scanner scanMartialArtistMagDefStatTxt = 
                                new Scanner(MartialArtistMagDefStatTxt);
                        //read the MartialArtistMagDefStat.txt file
                        String MartialArtistMagDefStat = 
                                scanMartialArtistMagDefStatTxt.next();
                        
                        try
                        {
                            System.out.print("Enter the name of your save file"+
                            " (be sure to not overwrite any other save files"+
                            " you have\nby using the same save file name more"+
                            " than once): ");
                            userNamedSaveFile = scan.next();
                            System.out.println();
                            
                            FileWriter writeUserSave = 
                                    new FileWriter("src/SavedCharacters/"+
                                    userNamedSaveFile+".txt");
                            
                            /*Write "Martial Artist Class" to the character's
                            user created
                            save file so that it can later be read when the user
                            loads their file to load their character so that the
                            character's class can be determined as "Martial Artist"
                            upon the load of the character in the userMainMenu #3
                            option.*/
                            writeUserSave.write("Martial Artist Class"+"\n"+
                            MartialArtistFirstName2+"\n"+
                                    MartialArtistLastName2+"\n"+
                            MartialArtistAccuracyStat+"\n"+
                                    MartialArtistAttackStat+"\n"+
                            MartialArtistDamageStat+"\n"+
                                    MartialArtistPhyDefStat+"\n"+
                            MartialArtistMagDefStat);
                            writeUserSave.close();
                            System.out.print("\""+MartialArtistFirstName2+' '+
                            MartialArtistLastName2
                                    +"\" the Martial Artist has been saved"+
                            " to the "+userNamedSaveFile
                                    +".txt file.\nPress"+
                            " enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                            
                        }
               
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                    }
                    
                    else if(userSave.equals("n") || userSave.equals("N"))
                    {
                        System.out.print("Ok, no characters will be saved to"+
                        " any files. Press enter to continue.");
                        try{System.in.read();}
                        catch(Exception e){}
                        System.out.println();
                        System.out.println();
                    }
                    
                    else
                    {
                        System.out.print("You must enter \"y\" to save"+
                        " a character or \"n\" to not do so, please try"+
                        " again. Press enter to continue.");
                        try{System.in.read();}
                        catch(Exception e){}
                        System.out.println();
                        System.out.println();
                    }
                }
                
                //if the character being saved is of the Necromancer Class
                if(selectedCharacterClass.contains(thisIsNecromancer))
                {
                    //will retrieve NecromancerFirstName.txt
                    File Necromancer1stFile = 
                            new File("src/NecromancerFirstName.txt");
                    Scanner scanNecromancerFirstName = 
                            new Scanner(Necromancer1stFile);
                
                    //will retrieve NecromancerLastName.txt
                    File Necromancer2ndFile = 
                            new File("src/NecromancerLastName.txt");
                    Scanner scanNecromancerLastName = 
                            new Scanner(Necromancer2ndFile);
                
                    /*read the NecromancerFirstName.txt file &
                    NecromancerLastName.txt file*/
                    String NecromancerFirstNameTxt = 
                            scanNecromancerFirstName.next();
                    String NecromancerLastNameTxt = 
                            scanNecromancerLastName.next();
                    
                    String userSave;
                    System.out.print("Are you sure you want to save your"+
                    " currently selected character: \""+
                            NecromancerFirstNameTxt+" "+
                            NecromancerLastNameTxt+
                            "\" the Necromancer?\nIf yes enter y"+
                            ", or if no enter n: ");
                    userSave = scan.next();
                    System.out.println();
                    if(userSave.equals("y") || userSave.equals("Y"))
                    {
                        /*retrieve all Necromancer Files: Name and Stat files*/
                        //------------------------------------------------------
                        
                        //retrieve NecromancerFirstName.txt
                        File NecromancerFirstNameTxt2 = 
                                new File("src/NecromancerFirstName.txt");
                        Scanner scanNecromancerFirstNameTxt = 
                                new Scanner(NecromancerFirstNameTxt2);
                        //read the NecromancerFirstName.txt file
                        String NecromancerFirstName2 = 
                                scanNecromancerFirstNameTxt.next();
                        
                        //retrieve NecromancerLastName.txt
                        File NecromancerLastNameTxt2 = 
                                new File("src/NecromancerLastName.txt");
                        Scanner scanNecromancerLastNameTxt = 
                                new Scanner(NecromancerLastNameTxt2);
                        //read the NecromancerLastName.txt file
                        String NecromancerLastName2 = 
                                scanNecromancerLastNameTxt.next();
                        
                        //retrieve NecromancerAccuracyStat.txt
                        File NecromancerAccuracyStatTxt = 
                                new File("src/NecromancerAccuracyStat.txt");
                        Scanner scanNecromancerAccuracyStatTxt = 
                                new Scanner(NecromancerAccuracyStatTxt);
                        //read the NecromancerAccuracyStat.txt file
                        String NecromancerAccuracyStat = 
                                scanNecromancerAccuracyStatTxt.next();
                        
                        //retrieve NecromancerAttackStat.txt
                        File NecromancerAttackStatTxt = 
                                new File("src/NecromancerAttackStat.txt");
                        Scanner scanNecromancerAttackStatTxt = 
                                new Scanner(NecromancerAttackStatTxt);
                        //read the NecromancerAttackStat.txt file 
                        String NecromancerAttackStat = 
                                scanNecromancerAttackStatTxt.next();
                        
                        //retrieve NecromancerDamageStat.txt
                        File NecromancerDamageStatTxt = 
                                new File("src/NecromancerDamageStat.txt");
                        Scanner scanNecromancerDamageStatTxt = 
                                new Scanner(NecromancerDamageStatTxt);
                        //read the NecromancerDamageStat.txt file
                        String NecromancerDamageStat = 
                                scanNecromancerDamageStatTxt.next();
                        
                        //retrieve NecromancerPhyDefStat.txt
                        File NecromancerPhyDefStatTxt = 
                                new File("src/NecromancerPhyDefStat.txt");
                        Scanner scanNecromancerPhyDefStatTxt = 
                                new Scanner(NecromancerPhyDefStatTxt);
                        //read the NecromancerPhyDefStat.txt file
                        String NecromancerPhyDefStat = 
                                scanNecromancerPhyDefStatTxt.next();
                        
                        //retrieve NecromancerMagDefStat.txt
                        File NecromancerMagDefStatTxt = 
                                new File("src/NecromancerMagDefStat.txt");
                        Scanner scanNecromancerMagDefStatTxt = 
                                new Scanner(NecromancerMagDefStatTxt);
                        //read the NecromancerMagDefStat.txt file
                        String NecromancerMagDefStat = 
                                scanNecromancerMagDefStatTxt.next();
                        
                        try
                        {
                            System.out.print("Enter the name of your save file"+
                            " (be sure to not overwrite any other save files"+
                            " you have\nby using the same save file name more"+
                            " than once): ");
                            userNamedSaveFile = scan.next();
                            System.out.println();
                            
                            FileWriter writeUserSave = 
                                    new FileWriter("src/SavedCharacters/"+
                                    userNamedSaveFile+".txt");
                            
                            /*Write "Necromancer Class" to the character's user
                            created
                            save file so that it can later be read when the user
                            loads their file to load their character so that the
                            character's class can be determined as "Necromancer"
                            upon the load of the character in the userMainMenu #3
                            option.*/
                            writeUserSave.write("Necromancer Class"+"\n"+
                            NecromancerFirstName2+"\n"+NecromancerLastName2+"\n"+
                            NecromancerAccuracyStat+"\n"+NecromancerAttackStat+"\n"+
                            NecromancerDamageStat+"\n"+NecromancerPhyDefStat+"\n"+
                            NecromancerMagDefStat);
                            writeUserSave.close();
                            System.out.print("\""+NecromancerFirstName2+' '+
                            NecromancerLastName2+"\" the Necromancer has been saved"+
                            " to the "+userNamedSaveFile+".txt file.\nPress"+
                            " enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                            
                        }
               
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                    }
                    
                    else if(userSave.equals("n") || userSave.equals("N"))
                    {
                        System.out.print("Ok, no characters will be saved to"+
                        " any files. Press enter to continue.");
                        try{System.in.read();}
                        catch(Exception e){}
                        System.out.println();
                        System.out.println();
                    }
                    
                    else
                    {
                        System.out.print("You must enter \"y\" to save"+
                        " a character or \"n\" to not do so, please try"+
                        " again. Press enter to continue.");
                        try{System.in.read();}
                        catch(Exception e){}
                        System.out.println();
                        System.out.println();
                    }
                }
                
                //if the character being saved is of the Wizard Class
                if(selectedCharacterClass.contains(thisIsWizard))
                {
                    //will retrieve WizardFirstName.txt
                    File Wizard1stFile = new File("src/WizardFirstName.txt");
                    Scanner scanWizardFirstName = new Scanner(Wizard1stFile);
                
                    //will retrieve WizardLastName.txt
                    File Wizard2ndFile = new File("src/WizardLastName.txt");
                    Scanner scanWizardLastName = new Scanner(Wizard2ndFile);
                
                    //read the WizardFirstName.txt file & WizardLastName.txt file
                    String WizardFirstNameTxt = scanWizardFirstName.next();
                    String WizardLastNameTxt = scanWizardLastName.next();
                    
                    String userSave;
                    System.out.print("Are you sure you want to save your"+
                    " currently selected character: \""+WizardFirstNameTxt+" "+
                            WizardLastNameTxt+"\" the Wizard?\nIf yes enter y"+
                            ", or if no enter n: ");
                    userSave = scan.next();
                    System.out.println();
                    if(userSave.equals("y") || userSave.equals("Y"))
                    {
                        /*retrieve all Wizard Files: Name and Stat files*/
                        //------------------------------------------------------
                        
                        //retrieve WizardFirstName.txt
                        File WizardFirstNameTxt2 = 
                                new File("src/WizardFirstName.txt");
                        Scanner scanWizardFirstNameTxt = 
                                new Scanner(WizardFirstNameTxt2);
                        //read the WizardFirstName.txt file
                        String WizardFirstName2 = scanWizardFirstNameTxt.next();
                        
                        //retrieve WizardLastName.txt
                        File WizardLastNameTxt2 = 
                                new File("src/WizardLastName.txt");
                        Scanner scanWizardLastNameTxt = 
                                new Scanner(WizardLastNameTxt2);
                        //read the WizardLastName.txt file
                        String WizardLastName2 = scanWizardLastNameTxt.next();
                        
                        //retrieve WizardAccuracyStat.txt
                        File WizardAccuracyStatTxt = 
                                new File("src/WizardAccuracyStat.txt");
                        Scanner scanWizardAccuracyStatTxt = 
                                new Scanner(WizardAccuracyStatTxt);
                        //read the WizardAccuracyStat.txt file
                        String WizardAccuracyStat = 
                                scanWizardAccuracyStatTxt.next();
                        
                        //retrieve WizardAttackStat.txt
                        File WizardAttackStatTxt = 
                                new File("src/WizardAttackStat.txt");
                        Scanner scanWizardAttackStatTxt = 
                                new Scanner(WizardAttackStatTxt);
                        //read the WizardAttackStat.txt file 
                        String WizardAttackStat = 
                                scanWizardAttackStatTxt.next();
                        
                        //retrieve WizardDamageStat.txt
                        File WizardDamageStatTxt = 
                                new File("src/WizardDamageStat.txt");
                        Scanner scanWizardDamageStatTxt = 
                                new Scanner(WizardDamageStatTxt);
                        //read the WizardDamageStat.txt file
                        String WizardDamageStat = 
                                scanWizardDamageStatTxt.next();
                        
                        //retrieve WizardPhyDefStat.txt
                        File WizardPhyDefStatTxt = 
                                new File("src/WizardPhyDefStat.txt");
                        Scanner scanWizardPhyDefStatTxt = 
                                new Scanner(WizardPhyDefStatTxt);
                        //read the WizardPhyDefStat.txt file
                        String WizardPhyDefStat = scanWizardPhyDefStatTxt.next();
                        
                        //retrieve WizardMagDefStat.txt
                        File WizardMagDefStatTxt = 
                                new File("src/WizardMagDefStat.txt");
                        Scanner scanWizardMagDefStatTxt = 
                                new Scanner(WizardMagDefStatTxt);
                        //read the WizardMagDefStat.txt file
                        String WizardMagDefStat = scanWizardMagDefStatTxt.next();
                        
                        try
                        {
                            System.out.print("Enter the name of your save file"+
                            " (be sure to not overwrite any other save files"+
                            " you have\nby using the same save file name more"+
                            " than once): ");
                            userNamedSaveFile = scan.next();
                            System.out.println();
                            
                            FileWriter writeUserSave = 
                                    new FileWriter("src/SavedCharacters/"+
                                    userNamedSaveFile+".txt");
                            
                            /*Write "Wizard Class" to the character's user created
                            save file so that it can later be read when the user
                            loads their file to load their character so that the
                            character's class can be determined as "Wizard"
                            upon the load of the character in the userMainMenu #3
                            option.*/
                            writeUserSave.write("Wizard Class"+"\n"+
                            WizardFirstName2+"\n"+WizardLastName2+"\n"+
                            WizardAccuracyStat+"\n"+WizardAttackStat+"\n"+
                            WizardDamageStat+"\n"+WizardPhyDefStat+"\n"+
                            WizardMagDefStat);
                            writeUserSave.close();
                            System.out.print("\""+WizardFirstName2+' '+
                            WizardLastName2+"\" the Wizard has been saved"+
                            " to the "+userNamedSaveFile+".txt file.\nPress"+
                            " enter to continue.");
                            try{System.in.read();}
                            catch(Exception e){}
                            System.out.println();
                            System.out.println();
                            
                        }
               
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                    }
                    
                    else if(userSave.equals("n") || userSave.equals("N"))
                    {
                        System.out.print("Ok, no characters will be saved to"+
                        " any files. Press enter to continue.");
                        try{System.in.read();}
                        catch(Exception e){}
                        System.out.println();
                        System.out.println();
                    }
                    
                    else
                    {
                        System.out.print("You must enter \"y\" to save"+
                        " a character or \"n\" to not do so, please try"+
                        " again. Press enter to continue.");
                        try{System.in.read();}
                        catch(Exception e){}
                        System.out.println();
                        System.out.println();
                    }
                }
            }
            
            else if(userMainMenu == 5)
            {
                /*This try is for when any of these files read do not exist. If 
                they don't exist the catch tells the user that they need to do.*/
                try
                {
               
                    //START: Get ASSASSIN class name and stat files
                    //--------------------------------------------------------------

                    //retrieve AssassinFirstName.txt
                    File AssassinFirstNameTxt2 = 
                            new File("src/AssassinFirstName.txt");
                    Scanner scanAssassinFirstNameTxt = 
                            new Scanner(AssassinFirstNameTxt2);
                    //read the AssassinFirstName.txt file
                    String AssassinFirstName2 = scanAssassinFirstNameTxt.next();

                    //retrieve AssassinLastName.txt
                    File AssassinLastNameTxt2 = new File("src/AssassinLastName.txt");
                    Scanner scanAssassinLastNameTxt = new Scanner(AssassinLastNameTxt2);
                    //read the AssassinLastName.txt file
                    String AssassinLastName2 = scanAssassinLastNameTxt.next();

                    //retrieve AssassinAccuracyStat.txt
                    File AssassinAccuracyStatTxt = 
                            new File("src/AssassinAccuracyStat.txt");
                    Scanner scanAssassinAccuracyStatTxt = 
                            new Scanner(AssassinAccuracyStatTxt);
                    //read the AssassinAccuracyStat.txt file
                    String AssassinAccuracyStat = 
                            scanAssassinAccuracyStatTxt.next();

                    //retrieve AssassinAttackStat.txt
                    File AssassinAttackStatTxt = 
                            new File("src/AssassinAttackStat.txt");
                    Scanner scanAssassinAttackStatTxt = 
                            new Scanner(AssassinAttackStatTxt);
                    //read the AssassinAttackStat.txt file 
                    String AssassinAttackStat = scanAssassinAttackStatTxt.next();

                    //Assassin Damage Stat isn't needed 

                    //retrieve AssassinPhyDefStat.txt
                    File AssassinPhyDefStatTxt = 
                            new File("src/AssassinPhyDefStat.txt");
                    Scanner scanAssassinPhyDefStatTxt = 
                            new Scanner(AssassinPhyDefStatTxt);
                    //read the AssassinPhyDefStat.txt file
                    String AssassinPhyDefStat = scanAssassinPhyDefStatTxt.next();

                    //retrieve AssassinMagDefStat.txt
                    File AssassinMagDefStatTxt = 
                            new File("src/AssassinMagDefStat.txt");
                    Scanner scanAssassinMagDefStatTxt = 
                            new Scanner(AssassinMagDefStatTxt);
                    //read the AssassinMagDefStat.txt file
                    String AssassinMagDefStat = scanAssassinMagDefStatTxt.next();

                    //END: All ASSASSIN class name and stat files have been read
                    //--------------------------------------------------------------

                    //START: Get ENGINEER class name and stat files
                    //--------------------------------------------------------------

                    //retrieve EngineerFirstName.txt
                    File EngineerFirstNameTxt2 = 
                            new File("src/EngineerFirstName.txt");
                    Scanner scanEngineerFirstNameTxt = 
                            new Scanner(EngineerFirstNameTxt2);
                    //read the EngineerFirstName.txt file
                    String EngineerFirstName2 = 
                            scanEngineerFirstNameTxt.next();

                    //retrieve EngineerLastName.txt
                    File EngineerLastNameTxt2 = new File("src/EngineerLastName.txt");
                    Scanner scanEngineerLastNameTxt = 
                            new Scanner(EngineerLastNameTxt2);
                    //read the EngineerLastName.txt file
                    String EngineerLastName2 = scanEngineerLastNameTxt.next();

                    //retrieve EngineerAccuracyStat.txt
                    File EngineerAccuracyStatTxt = 
                            new File("src/EngineerAccuracyStat.txt");
                    Scanner scanEngineerAccuracyStatTxt = 
                            new Scanner(EngineerAccuracyStatTxt);
                    //read the EngineerAccuracyStat.txt file
                    String EngineerAccuracyStat = scanEngineerAccuracyStatTxt.next();

                    //retrieve EngineerAttackStat.txt
                    File EngineerAttackStatTxt = 
                            new File("src/EngineerAttackStat.txt");
                    Scanner scanEngineerAttackStatTxt = 
                            new Scanner(EngineerAttackStatTxt);
                    //read the EngineerAttackStat.txt file 
                    String EngineerAttackStat = scanEngineerAttackStatTxt.next();

                    //Engineer Damage Stat isn't needed

                    //retrieve EngineerPhyDefStat.txt
                    File EngineerPhyDefStatTxt = 
                            new File("src/EngineerPhyDefStat.txt");
                    Scanner scanEngineerPhyDefStatTxt = 
                            new Scanner(EngineerPhyDefStatTxt);
                    //read the EngineerPhyDefStat.txt file
                    String EngineerPhyDefStat = scanEngineerPhyDefStatTxt.next();

                    //retrieve EngineerMagDefStat.txt
                    File EngineerMagDefStatTxt = 
                            new File("src/EngineerMagDefStat.txt");
                    Scanner scanEngineerMagDefStatTxt = 
                            new Scanner(EngineerMagDefStatTxt);
                    //read the EngineerMagDefStat.txt file
                    String EngineerMagDefStat = scanEngineerMagDefStatTxt.next();

                    //END: All ENGINEER class name and stat files have been read
                    //----------------------------------------------------------

                    //START: Get HEALER class name and stat files
                    //----------------------------------------------------------

                    //retrieve HealerFirstName.txt
                    File HealerFirstNameTxt2 = 
                            new File("src/HealerFirstName.txt");
                    Scanner scanHealerFirstNameTxt = 
                            new Scanner(HealerFirstNameTxt2);
                    //read the HealerFirstName.txt file
                    String HealerFirstName2 = scanHealerFirstNameTxt.next();

                    //retrieve HealerLastName.txt
                    File HealerLastNameTxt2 = 
                            new File("src/HealerLastName.txt");
                    Scanner scanHealerLastNameTxt = 
                            new Scanner(HealerLastNameTxt2);
                    //read the HealerLastName.txt file
                    String HealerLastName2 = scanHealerLastNameTxt.next();

                    //retrieve HealerAccuracyStat.txt
                    File HealerAccuracyStatTxt = 
                            new File("src/HealerAccuracyStat.txt");
                    Scanner scanHealerAccuracyStatTxt = 
                            new Scanner(HealerAccuracyStatTxt);
                    //read the HealerAccuracyStat.txt file
                    String HealerAccuracyStat = scanHealerAccuracyStatTxt.next();

                    //retrieve HealerAttackStat.txt
                    File HealerAttackStatTxt = new File("src/HealerAttackStat.txt");
                    Scanner scanHealerAttackStatTxt = new Scanner(HealerAttackStatTxt);
                    //read the HealerAttackStat.txt file 
                    String HealerAttackStat = scanHealerAttackStatTxt.next();

                    //Healer Damage Stat isn't needed

                    //retrieve HealerPhyDefStat.txt
                    File HealerPhyDefStatTxt = new File("src/HealerPhyDefStat.txt");
                    Scanner scanHealerPhyDefStatTxt = new Scanner(HealerPhyDefStatTxt);
                    //read the HealerPhyDefStat.txt file
                    String HealerPhyDefStat = scanHealerPhyDefStatTxt.next();

                    //retrieve HealerMagDefStat.txt
                    File HealerMagDefStatTxt = new File("src/HealerMagDefStat.txt");
                    Scanner scanHealerMagDefStatTxt = new Scanner(HealerMagDefStatTxt);
                    //read the HealerMagDefStat.txt file
                    String HealerMagDefStat = scanHealerMagDefStatTxt.next();

                    //END: All HEALER class name and stat files have been read
                    //----------------------------------------------------------

                    //START: Get MARTIAL ARTIST class name and stat files
                    //----------------------------------------------------------

                    //retrieve MartialArtistFirstName.txt
                    File MartialArtistFirstNameTxt2 = 
                            new File("src/MartialArtistFirstName.txt");
                    Scanner scanMartialArtistFirstNameTxt = 
                            new Scanner(MartialArtistFirstNameTxt2);
                    //read the MartialArtistFirstName.txt file
                    String MartialArtistFirstName2 = 
                            scanMartialArtistFirstNameTxt.next();

                    //retrieve MartialArtistLastName.txt
                    File MartialArtistLastNameTxt2 = 
                            new File("src/MartialArtistLastName.txt");
                    Scanner scanMartialArtistLastNameTxt = 
                            new Scanner(MartialArtistLastNameTxt2);
                    //read the MartialArtistLastName.txt file
                    String MartialArtistLastName2 = 
                            scanMartialArtistLastNameTxt.next();

                    //retrieve MartialArtistAccuracyStat.txt
                    File MartialArtistAccuracyStatTxt = 
                            new File("src/MartialArtistAccuracyStat.txt");
                    Scanner scanMartialArtistAccuracyStatTxt = 
                            new Scanner(MartialArtistAccuracyStatTxt);
                    //read the MartialArtistAccuracyStat.txt file
                    String MartialArtistAccuracyStat = 
                            scanMartialArtistAccuracyStatTxt.next();

                    //retrieve MartialArtistAttackStat.txt
                    File MartialArtistAttackStatTxt = 
                            new File("src/MartialArtistAttackStat.txt");
                    Scanner scanMartialArtistAttackStatTxt = 
                            new Scanner(MartialArtistAttackStatTxt);
                    //read the MartialArtistAttackStat.txt file 
                    String MartialArtistAttackStat = 
                            scanMartialArtistAttackStatTxt.next();

                    //Martial Artist Damage Stat isn't needed

                    //retrieve MartialArtistPhyDefStat.txt
                    File MartialArtistPhyDefStatTxt = 
                            new File("src/MartialArtistPhyDefStat.txt");
                    Scanner scanMartialArtistPhyDefStatTxt = 
                            new Scanner(MartialArtistPhyDefStatTxt);
                    //read the MartialArtistPhyDefStat.txt file
                    String MartialArtistPhyDefStat = 
                            scanMartialArtistPhyDefStatTxt.next();

                    //retrieve MartialArtistMagDefStat.txt
                    File MartialArtistMagDefStatTxt = 
                            new File("src/MartialArtistMagDefStat.txt");
                    Scanner scanMartialArtistMagDefStatTxt = 
                            new Scanner(MartialArtistMagDefStatTxt);
                    //read the MartialArtistMagDefStat.txt file
                    String MartialArtistMagDefStat = 
                            scanMartialArtistMagDefStatTxt.next();

                    //END: All MARTIAL ARTIST class name and stat files have been read
                    //--------------------------------------------------------------

                    //START: Get NECROMANCER class name and stat files
                    //--------------------------------------------------------------

                    //retrieve NecromancerFirstName.txt
                    File NecromancerFirstNameTxt2 = 
                            new File("src/NecromancerFirstName.txt");
                    Scanner scanNecromancerFirstNameTxt = 
                            new Scanner(NecromancerFirstNameTxt2);
                    //read the NecromancerFirstName.txt file
                    String NecromancerFirstName2 = 
                            scanNecromancerFirstNameTxt.next();

                    //retrieve NecromancerLastName.txt
                    File NecromancerLastNameTxt2 = 
                            new File("src/NecromancerLastName.txt");
                    Scanner scanNecromancerLastNameTxt = 
                            new Scanner(NecromancerLastNameTxt2);
                    //read the NecromancerLastName.txt file
                    String NecromancerLastName2 = 
                            scanNecromancerLastNameTxt.next();

                    //retrieve NecromancerAccuracyStat.txt
                    File NecromancerAccuracyStatTxt = 
                            new File("src/NecromancerAccuracyStat.txt");
                    Scanner scanNecromancerAccuracyStatTxt = 
                            new Scanner(NecromancerAccuracyStatTxt);
                    //read the NecromancerAccuracyStat.txt file
                    String NecromancerAccuracyStat = 
                            scanNecromancerAccuracyStatTxt.next();

                    //retrieve NecromancerAttackStat.txt
                    File NecromancerAttackStatTxt = 
                            new File("src/NecromancerAttackStat.txt");
                    Scanner scanNecromancerAttackStatTxt = 
                            new Scanner(NecromancerAttackStatTxt);
                    //read the NecromancerAttackStat.txt file 
                    String NecromancerAttackStat = 
                            scanNecromancerAttackStatTxt.next();

                    //Necromancer Damage Stat isn't needed

                    //retrieve NecromancerPhyDefStat.txt
                    File NecromancerPhyDefStatTxt = 
                            new File("src/NecromancerPhyDefStat.txt");
                    Scanner scanNecromancerPhyDefStatTxt = 
                            new Scanner(NecromancerPhyDefStatTxt);
                    //read the NecromancerPhyDefStat.txt file
                    String NecromancerPhyDefStat = 
                            scanNecromancerPhyDefStatTxt.next();

                    //retrieve NecromancerMagDefStat.txt
                    File NecromancerMagDefStatTxt = 
                            new File("src/NecromancerMagDefStat.txt");
                    Scanner scanNecromancerMagDefStatTxt = 
                            new Scanner(NecromancerMagDefStatTxt);
                    //read the NecromancerMagDefStat.txt file
                    String NecromancerMagDefStat = 
                            scanNecromancerMagDefStatTxt.next();

                    //END: All NECROMANCER class name and stat files have been read
                    //----------------------------------------------------------

                    //START: Get WIZARD class name and stat files
                    //----------------------------------------------------------

                    //retrieve WizardFirstName.txt
                    File WizardFirstNameTxt2 = 
                            new File("src/WizardFirstName.txt");
                    Scanner scanWizardFirstNameTxt = 
                            new Scanner(WizardFirstNameTxt2);
                    //read the WizardFirstName.txt file
                    String WizardFirstName2 = scanWizardFirstNameTxt.next();

                    //retrieve WizardLastName.txt
                    File WizardLastNameTxt2 = new File("src/WizardLastName.txt");
                    Scanner scanWizardLastNameTxt = 
                            new Scanner(WizardLastNameTxt2);
                    //read the WizardLastName.txt file
                    String WizardLastName2 = scanWizardLastNameTxt.next();

                    //retrieve WizardAccuracyStat.txt
                    File WizardAccuracyStatTxt = new File("src/WizardAccuracyStat.txt");
                    Scanner scanWizardAccuracyStatTxt = 
                            new Scanner(WizardAccuracyStatTxt);
                    //read the WizardAccuracyStat.txt file
                    String WizardAccuracyStat = scanWizardAccuracyStatTxt.next();

                    //retrieve WizardAttackStat.txt
                    File WizardAttackStatTxt = new File("src/WizardAttackStat.txt");
                    Scanner scanWizardAttackStatTxt = 
                            new Scanner(WizardAttackStatTxt);
                    //read the WizardAttackStat.txt file 
                    String WizardAttackStat = scanWizardAttackStatTxt.next();

                    //Wizard Damage Stat isn't needed

                    //retrieve WizardPhyDefStat.txt
                    File WizardPhyDefStatTxt = 
                            new File("src/WizardPhyDefStat.txt");
                    Scanner scanWizardPhyDefStatTxt = 
                            new Scanner(WizardPhyDefStatTxt);
                    //read the WizardPhyDefStat.txt file
                    String WizardPhyDefStat = scanWizardPhyDefStatTxt.next();

                    //retrieve WizardMagDefStat.txt
                    File WizardMagDefStatTxt = 
                            new File("src/WizardMagDefStat.txt");
                    Scanner scanWizardMagDefStatTxt = 
                            new Scanner(WizardMagDefStatTxt);
                    //read the WizardMagDefStat.txt file
                    String WizardMagDefStat = scanWizardMagDefStatTxt.next();

                    //END: All WIZARD class name and stat files have been read
                    //--------------------------------------------------------------

                    /*throughtout the program the selectedCharacter & selectedCharacter
                    Class lists always get added to at the same time and when they are 
                    emptied they are both emptied at the same time, so one of them 
                    being empty and the other having something in it shouldn't even
                    be possible because of the aforementioned reason. So they are
                    either both empty or both have values in them. */
                    if(selectedCharacter.isEmpty() &&
                            selectedCharacterClass.isEmpty())
                    {
                        System.out.print("You must either create"+
                                " a character, select"+
                        " an existing character, or load a character from a"+
                        " file\nbefore you can perform an action. Press enter"+
                        " to continue.");
                        try{System.in.read();}
                        catch(Exception e){}
                        System.out.println();
                        System.out.println();
                    }

                    //if there is a currently selected character
                    else
                    {
                        int userRollChoice;
                        System.out.println("Perform an action");
                        System.out.println("--------------------");
                        System.out.println("1. Roll for Attack\n"+
                        "2. Roll for Damage\n"+
                        "3. Roll for Physical Defense\n"+
                        "4. Roll for Magical Defense\n"+
                        "5. Return to main menu");
                        System.out.println();
                        System.out.print("Enter your roll choice: ");
                        userRollChoice = scan.nextInt();
                        System.out.println();
                        System.out.println();
                        while(userRollChoice != 5)
                        {
                            //input validation
                            while(userRollChoice <=0 || userRollChoice >=6)
                            {
                                System.out.println("Perform an action");
                                System.out.println("--------------------");
                                System.out.println("1. Roll for Attack\n"+
                                "2. Roll for Damage\n"+
                                "3. Roll for Physical Defense\n"+
                                "4. Roll for Magical Defense\n"+
                                "5. Return to main menu");
                                System.out.println();
                                System.out.print("You must not enter a value less"+
                                " than 1 or greater than 5.\nEnter your roll choice: ");
                                userRollChoice = scan.nextInt();
                                System.out.println();
                                System.out.println();
                            }

                            //if the currently selected character is an Assasssin
                            if(selectedCharacterClass.contains(thisIsAssassin))
                            {

                                // START: Get Assassin Accuracy Stat value
                                //----------------------------------------------

                                int AssassinAccuracyStatInt;

                                /*turn the String AssassinAccuracyStat into int data
                                type so that the value can be used in methods that
                                require the value to be of int type*/
                                AssassinAccuracyStatInt = 
                                        Integer.valueOf(AssassinAccuracyStat);

                                //END: Got Assassin Accuracy Stat value
                                //----------------------------------------------

                                /* START: Get Assasin getAttack object &
                                Attack Stat value*/
                                //----------------------------------------------

                                getAttack assassinAttack = new getAttack();

                                int AssassinAttackStatInt;

                                /*turn the String AssassinAttackStat into int data
                                type so that the value can be used in methods that
                                require the value to be of int type*/
                                AssassinAttackStatInt = 
                                        Integer.valueOf(AssassinAttackStat);

                                /*END: Got Assassin getAttack object &
                                Attack Stat value*/
                                //----------------------------------------------

                                // START: Get Assasin getDamage object
                                //----------------------------------------------

                                getDamage assassinDamage = new getDamage();

                                //END: Got Assassin getDamage object
                                //--------------------------------------------------

                                /* START: Get Assassin getPhyDef object &
                                Physical Defense Stat value*/
                                //--------------------------------------------------

                                getPhyDef assassinPhyDef = new getPhyDef();

                                int AssassinPhyDefStatInt;

                                /*turn the String AssassinPhyDefStat into int data
                                type so that the value can be used in methods that
                                require the value to be of int type*/
                                AssassinPhyDefStatInt = 
                                        Integer.valueOf(AssassinPhyDefStat);

                                /*END: Got Assassin getPhyDef object &
                                PhyDef Stat value*/
                                //----------------------------------------------

                                /* START: Get Assassin getMagDef object &
                                Magical Defense Stat value*/
                                //----------------------------------------------

                                getMagDef assassinMagDef = new getMagDef();

                                int AssassinMagDefStatInt;

                                /*turn the String AssassinMagDefStat into int data
                                type so that the value can be used in methods that
                                require the value to be of int type*/
                                AssassinMagDefStatInt = 
                                        Integer.valueOf(AssassinMagDefStat);

                                /*END: Got Assassin getMagDef object &
                                MagDef Stat value*/
                                //----------------------------------------------



                                //roll for attack
                                if(userRollChoice == 1)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum1;

                                    /*random # between 1-1000*/
                                    randomNum1 = generator.nextInt(rangeInt2)+rangeInt1;

                                    int assassinAttackValue = 
                                    assassinAttack.rollForAttack(randomNum1,
                                            AssassinAccuracyStatInt);

                                    System.out.println(AssassinFirstName2+
                                    " "+AssassinLastName2+" rolls for "+randomNum1+
                                    ". "+randomNum1+" + "+AssassinAccuracyStatInt+
                                    " Accuracy = "+assassinAttackValue+" Attack");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }

                                //roll for Damage
                                else if(userRollChoice == 2)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum2;

                                    /*random # between 1-1000*/
                                    randomNum2 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int assassinDamageValue = 
                                    assassinDamage.rollForDamage(randomNum2,
                                            AssassinAttackStatInt);

                                    System.out.println(AssassinFirstName2+
                                    " "+AssassinLastName2+" rolls for "+randomNum2+
                                    ". "+randomNum2+" + "+AssassinAttackStatInt+
                                    " Attack = "+assassinDamageValue+" Damage");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }

                                //roll for Physical Defense
                                else if(userRollChoice == 3)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum3;

                                    /*random # between 1-1000*/
                                    randomNum3 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int assassinPhyDefValue = 
                                    assassinPhyDef.rollForPhyDef(randomNum3,
                                            AssassinPhyDefStatInt);

                                    System.out.println(AssassinFirstName2+
                                    " "+AssassinLastName2+" rolls for "+randomNum3+
                                    ". "+randomNum3+" + "+AssassinPhyDefStatInt+
                                    " Physical Defense = "+
                                            assassinPhyDefValue+" Physical Defense");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }

                                //roll for Magical Defense
                                else if(userRollChoice == 4)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum4;

                                    /*random # between 1-1000*/
                                    randomNum4 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int assassinMagDefValue = 
                                    assassinMagDef.rollForMagDef(randomNum4,
                                            AssassinMagDefStatInt);

                                    System.out.println(AssassinFirstName2+
                                    " "+AssassinLastName2+" rolls for "+randomNum4+
                                    ". "+randomNum4+" + "+AssassinMagDefStatInt+
                                    " Magical Defense = "+
                                            assassinMagDefValue+
                                            " Magical Defense");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }
                            }

                            //if the currently selected character is an Engineer
                            else if(selectedCharacterClass.contains(thisIsEngineer))
                            {

                                // START: Get Engineer Accuracy Stat value
                                //----------------------------------------------

                                int EngineerAccuracyStatInt;

                                /*turn the String EngineerAccuracyStat into int data
                                type so that the value can be used in methods that
                                require the value to be of int type*/
                                EngineerAccuracyStatInt = 
                                        Integer.valueOf(EngineerAccuracyStat);

                                //END: Got Engineer Accuracy Stat value
                                //----------------------------------------------

                                /* START: Get Engineer getAttack object &
                                Attack Stat value*/
                                //----------------------------------------------

                                getAttack engineerAttack = new getAttack();

                                int EngineerAttackStatInt;

                                /*turn the String EngineerAttackStat into int data
                                type so that the value can be used in methods that
                                require the value to be of int type*/
                                EngineerAttackStatInt = 
                                        Integer.valueOf(EngineerAttackStat);

                                /*END: Got Engineer getAttack object &
                                Attack Stat value*/
                                //----------------------------------------------

                                // START: Get Engineer getDamage object
                                //----------------------------------------------

                                getDamage engineerDamage = new getDamage();

                                //END: Got Engineer getDamage object
                                //----------------------------------------------

                                /* START: Get Engineer getPhyDef object &
                                Physical Defense Stat value*/
                                //----------------------------------------------

                                getPhyDef engineerPhyDef = new getPhyDef();

                                int EngineerPhyDefStatInt;

                                /*turn the String EngineerPhyDefStat into int data
                                type so that the value can be used in methods that
                                require the value to be of int type*/
                                EngineerPhyDefStatInt = 
                                        Integer.valueOf(EngineerPhyDefStat);

                                /*END: Got Engineer getPhyDef object &
                                PhyDef Stat value*/
                                //----------------------------------------------

                                /*START: Get Engineer getMagDef object &
                                Magical Defense Stat value*/
                                //----------------------------------------------

                                getMagDef engineerMagDef = new getMagDef();

                                int EngineerMagDefStatInt;

                                /*turn the String EngineerMagDefStat into int data
                                type so that the value can be used in methods that
                                require the value to be of int type*/
                                EngineerMagDefStatInt = 
                                        Integer.valueOf(EngineerMagDefStat);

                                /*END: Got Engineer getMagDef object &
                                MagDef Stat value*/
                                //----------------------------------------------



                                //roll for attack
                                if(userRollChoice == 1)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum1;

                                    /*random # between 1-1000*/
                                    randomNum1 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int engineerAttackValue = 
                                    engineerAttack.rollForAttack(randomNum1,
                                            EngineerAccuracyStatInt);

                                    System.out.println(EngineerFirstName2+
                                    " "+EngineerLastName2+" rolls for "+randomNum1+
                                    ". "+randomNum1+" + "+EngineerAccuracyStatInt+
                                    " Accuracy = "+engineerAttackValue+" Attack");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }

                                //roll for Damage
                                else if(userRollChoice == 2)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum2;

                                    /*random # between 1-1000*/
                                    randomNum2 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int engineerDamageValue = 
                                    engineerDamage.rollForDamage(randomNum2,
                                            EngineerAttackStatInt);

                                    System.out.println(EngineerFirstName2+
                                    " "+EngineerLastName2+" rolls for "+randomNum2+
                                    ". "+randomNum2+" + "+EngineerAttackStatInt+
                                    " Attack = "+engineerDamageValue+" Damage");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }

                                //roll for Physical Defense
                                else if(userRollChoice == 3)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum3;

                                    /*random # between 1-1000*/
                                    randomNum3 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int engineerPhyDefValue = 
                                    engineerPhyDef.rollForPhyDef(randomNum3,
                                            EngineerPhyDefStatInt);

                                    System.out.println(EngineerFirstName2+
                                    " "+EngineerLastName2+" rolls for "+randomNum3+
                                    ". "+randomNum3+" + "+EngineerPhyDefStatInt+
                                    " Physical Defense = "+
                                            engineerPhyDefValue+" Physical Defense");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }

                                //roll for Magical Defense
                                else if(userRollChoice == 4)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum4;

                                    /*random # between 1-1000*/
                                    randomNum4 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int engineerMagDefValue = 
                                    engineerMagDef.rollForMagDef(randomNum4,
                                            EngineerMagDefStatInt);

                                    System.out.println(EngineerFirstName2+
                                    " "+EngineerLastName2+" rolls for "+randomNum4+
                                    ". "+randomNum4+" + "+EngineerMagDefStatInt+
                                    " Magical Defense = "+
                                            engineerMagDefValue+" Magical Defense");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }
                            }

                            //if the currently selected character is a Healer
                            else if(selectedCharacterClass.contains(thisIsHealer))
                            {

                                // START: Get Healer Accuracy Stat value
                                //----------------------------------------------

                                int HealerAccuracyStatInt;

                                /*turn the String HealerAccuracyStat into int data
                                type so that the value can be used in methods that
                                require the value to be of int type*/
                                HealerAccuracyStatInt = 
                                        Integer.valueOf(HealerAccuracyStat);

                                //END: Got Healer Accuracy Stat value
                                //----------------------------------------------

                                /* START: Get Healer getAttack object &
                                Attack Stat value*/
                                //----------------------------------------------

                                getAttack healerAttack = new getAttack();

                                int HealerAttackStatInt;

                                /*turn the String HealerAttackStat into int data
                                type so that the value can be used in methods that
                                require the value to be of int type*/
                                HealerAttackStatInt = 
                                        Integer.valueOf(HealerAttackStat);

                                /*END: Got Healer getAttack object &
                                Attack Stat value*/
                                //----------------------------------------------

                                // START: Get Healer getDamage object
                                //----------------------------------------------

                                getDamage healerDamage = new getDamage();

                                //END: Got Healer getDamage object
                                //-----------------------------------------------
                                
                                /* START: Get Healer getPhyDef object &
                                Physical Defense Stat value*/
                                //----------------------------------------------

                                getPhyDef healerPhyDef = new getPhyDef();

                                int HealerPhyDefStatInt;

                                /*turn the String HealerPhyDefStat into int data
                                type so that the value can be used in methods that
                                require the value to be of int type*/
                                HealerPhyDefStatInt = 
                                        Integer.valueOf(HealerPhyDefStat);

                                /*END: Got Healer getPhyDef object &
                                PhyDef Stat value*/
                                //----------------------------------------------

                                /* START: Get Healer getMagDef object &
                                Magical Defense Stat value*/
                                //----------------------------------------------

                                getMagDef healerMagDef = new getMagDef();

                                int HealerMagDefStatInt;

                                /*turn the String HealerMagDefStat into int data
                                type so that the value can be used in methods that
                                require the value to be of int type*/
                                HealerMagDefStatInt = Integer.
                                        valueOf(HealerMagDefStat);

                                //END: Got Healer getMagDef object & MagDef Stat value
                                //----------------------------------------------



                                //roll for attack
                                if(userRollChoice == 1)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum1;

                                    /*random # between 1-1000*/
                                    randomNum1 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int healerAttackValue = 
                                    healerAttack.rollForAttack(randomNum1,
                                            HealerAccuracyStatInt);

                                    System.out.println(HealerFirstName2+
                                    " "+HealerLastName2+" rolls for "+randomNum1+
                                    ". "+randomNum1+" + "+HealerAccuracyStatInt+
                                    " Accuracy = "+healerAttackValue+" Attack");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }

                                //roll for Damage
                                else if(userRollChoice == 2)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum2;

                                    /*random # between 1-1000*/
                                    randomNum2 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int healerDamageValue = 
                                    healerDamage.rollForDamage(randomNum2,
                                            HealerAttackStatInt);

                                    System.out.println(HealerFirstName2+
                                    " "+HealerLastName2+" rolls for "+randomNum2+
                                    ". "+randomNum2+" + "+HealerAttackStatInt+
                                    " Attack = "+healerDamageValue+" Damage");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }

                                //roll for Physical Defense
                                else if(userRollChoice == 3)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum3;

                                    /*random # between 1-1000*/
                                    randomNum3 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int healerPhyDefValue = 
                                    healerPhyDef.rollForPhyDef(randomNum3,
                                            HealerPhyDefStatInt);

                                    System.out.println(HealerFirstName2+
                                    " "+HealerLastName2+" rolls for "+randomNum3+
                                    ". "+randomNum3+" + "+HealerPhyDefStatInt+
                                    " Physical Defense = "+
                                            healerPhyDefValue+" Physical Defense");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }

                                //roll for Magical Defense
                                else if(userRollChoice == 4)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum4;

                                    /*random # between 1-1000*/
                                    randomNum4 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int healerMagDefValue = 
                                    healerMagDef.rollForMagDef(randomNum4,
                                            HealerMagDefStatInt);

                                    System.out.println(HealerFirstName2+
                                    " "+HealerLastName2+" rolls for "+randomNum4+
                                    ". "+randomNum4+" + "+HealerMagDefStatInt+
                                    " Magical Defense = "+
                                            healerMagDefValue+" Magical Defense");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }
                            }

                            /*if the currently selected character is a Martial
                            Artist*/
                            else if(selectedCharacterClass.
                                    contains(thisIsMartialArtist))
                            {

                                // START: Get Martial Artist Accuracy Stat value
                                //--------------------------------------------------

                                int MartialArtistAccuracyStatInt;

                                /*turn the String MartialArtistAccuracyStat into
                                int data
                                type so that the value can be used in methods 
                                that
                                require the value to be of int type*/
                                MartialArtistAccuracyStatInt = 
                                        Integer.valueOf(MartialArtistAccuracyStat);

                                //END: Got Martial Artist Accuracy Stat value
                                //----------------------------------------------

                                /* START: Get Martial Artist getAttack object 
                                & Attack Stat value*/
                                //----------------------------------------------

                                getAttack martialArtistAttack = new getAttack();

                                int MartialArtistAttackStatInt;

                                /*turn the String MartialArtistAttackStat into
                                int data
                                type so that the value can be used in methods
                                that
                                require the value to be of int type*/
                                MartialArtistAttackStatInt = 
                                        Integer.valueOf(MartialArtistAttackStat);

                                /*END: Got Martial Artist getAttack object &
                                Attack Stat value*/
                                //----------------------------------------------

                                // START: Get Martial Artist getDamage object
                                //----------------------------------------------

                                getDamage martialArtistDamage = new getDamage();

                                //END: Got Martial Artist getDamage object
                                //----------------------------------------------

                                /* START: Get Martial Artist getPhyDef object 
                                & Physical Defense Stat value*/
                                //-----------------------------------------------
                                
                                getPhyDef martialArtistPhyDef = new getPhyDef();

                                int MartialArtistPhyDefStatInt;

                                /*turn the String MartialArtistPhyDefStat into
                                int data
                                type so that the value can be used in methods
                                that
                                require the value to be of int type*/
                                MartialArtistPhyDefStatInt = 
                                        Integer.valueOf(MartialArtistPhyDefStat);

                                /*END: Got Martial Artist getPhyDef object &
                                PhyDef Stat value*/
                                //----------------------------------------------

                                /* START: Get Martial Artist getMagDef object &
                                Magical Defense Stat value*/
                                //----------------------------------------------

                                getMagDef martialArtistMagDef = new getMagDef();

                                int MartialArtistMagDefStatInt;

                                /*turn the String MartialArtistMagDefStat into
                                int data
                                type so that the value can be used in methods
                                that
                                require the value to be of int type*/
                                MartialArtistMagDefStatInt = 
                                        Integer.valueOf(MartialArtistMagDefStat);

                                /*END: Got MartialArtist getMagDef object &
                                MagDef Stat value*/
                                //----------------------------------------------



                                //roll for attack
                                if(userRollChoice == 1)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum1;

                                    /*random # between 1-1000*/
                                    randomNum1 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int martialArtistAttackValue = 
                                    martialArtistAttack.rollForAttack(randomNum1,
                                            MartialArtistAccuracyStatInt);

                                    System.out.println(MartialArtistFirstName2+
                                    " "+MartialArtistLastName2+" rolls for "+
                                            randomNum1+
                                    ". "+randomNum1+" + "+
                                            MartialArtistAccuracyStatInt+
                                    " Accuracy = "+
                                            martialArtistAttackValue+" Attack");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }

                                //roll for Damage
                                else if(userRollChoice == 2)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum2;

                                    /*random # between 1-1000*/
                                    randomNum2 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int martialArtistDamageValue = 
                                    martialArtistDamage.rollForDamage(randomNum2,
                                            MartialArtistAttackStatInt);

                                    System.out.println(MartialArtistFirstName2+
                                    " "+MartialArtistLastName2+" rolls for "+
                                            randomNum2+
                                    ". "+randomNum2+" + "+
                                            MartialArtistAttackStatInt+
                                    " Attack = "+
                                            martialArtistDamageValue+" Damage");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }

                                //roll for Physical Defense
                                else if(userRollChoice == 3)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum3;

                                    /*random # between 1-1000*/
                                    randomNum3 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int martialArtistPhyDefValue = 
                                    martialArtistPhyDef.rollForPhyDef(randomNum3,
                                            MartialArtistPhyDefStatInt);

                                    System.out.println(MartialArtistFirstName2+
                                    " "+MartialArtistLastName2+" rolls for "+
                                            randomNum3+
                                    ". "+randomNum3+" + "+
                                            MartialArtistPhyDefStatInt+
                                    " Physical Defense = "+
                                            martialArtistPhyDefValue+
                                            " Physical Defense");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }

                                //roll for Magical Defense
                                else if(userRollChoice == 4)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum4;

                                    /*random # between 1-1000*/
                                    randomNum4 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int martialArtistMagDefValue = 
                                    martialArtistMagDef.rollForMagDef(randomNum4,
                                            MartialArtistMagDefStatInt);

                                    System.out.println(MartialArtistFirstName2+
                                    " "+MartialArtistLastName2+" rolls for "+
                                            randomNum4+
                                    ". "+randomNum4+" + "+
                                            MartialArtistMagDefStatInt+
                                    " Magical Defense = "+
                                            martialArtistMagDefValue+
                                            " Magical Defense");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }
                            }

                            //if the currently selected character is a Necromancer
                            else if(selectedCharacterClass.
                                    contains(thisIsNecromancer))
                            {

                                // START: Get Necromancer Accuracy Stat value
                                //----------------------------------------------

                                int NecromancerAccuracyStatInt;

                                /*turn the String NecromancerAccuracyStat into int data
                                type so that the value can be used in methods that
                                require the value to be of int type*/
                                NecromancerAccuracyStatInt = 
                                        Integer.valueOf(NecromancerAccuracyStat);

                                //END: Got Necromancer Accuracy Stat value
                                //----------------------------------------------

                                /* START: Get Necromancer getAttack object &
                                Attack Stat value*/
                                //----------------------------------------------

                                getAttack necromancerAttack = new getAttack();

                                int NecromancerAttackStatInt;

                                /*turn the String NecromancerAttackStat into int data
                                type so that the value can be used in methods that
                                require the value to be of int type*/
                                NecromancerAttackStatInt = 
                                        Integer.valueOf(NecromancerAttackStat);

                                /*END: Got Necromancer getAttack object &
                                Attack Stat value*/
                                //----------------------------------------------

                                // START: Get Necromancer getDamage object
                                //----------------------------------------------

                                getDamage necromancerDamage = new getDamage();

                                //END: Got Necromancer getDamage object
                                //----------------------------------------------

                                /* START: Get Necromancer getPhyDef object &
                                Physical Defense Stat value*/
                                //----------------------------------------------

                                getPhyDef necromancerPhyDef = new getPhyDef();

                                int NecromancerPhyDefStatInt;

                                /*turn the String NecromancerPhyDefStat into int data
                                type so that the value can be used in methods that
                                require the value to be of int type*/
                                NecromancerPhyDefStatInt = 
                                        Integer.valueOf(NecromancerPhyDefStat);

                                /*END: Got Necromancer getPhyDef object &
                                PhyDef Stat value*/
                                //----------------------------------------------

                                /* START: Get Necromancer getMagDef object &
                                Magical Defense Stat value*/
                                //----------------------------------------------

                                getMagDef necromancerMagDef = new getMagDef();

                                int NecromancerMagDefStatInt;

                                /*turn the String NecromancerMagDefStat into int
                                data
                                type so that the value can be used in methods
                                that
                                require the value to be of int type*/
                                NecromancerMagDefStatInt = 
                                        Integer.valueOf(NecromancerMagDefStat);

                                /*END: Got Necromancer getMagDef object &
                                MagDef Stat value*/
                                //----------------------------------------------



                                //roll for attack
                                if(userRollChoice == 1)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum1;

                                    /*random # between 1-1000*/
                                    randomNum1 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int necromancerAttackValue = 
                                    necromancerAttack.rollForAttack(randomNum1,
                                            NecromancerAccuracyStatInt);

                                    System.out.println(NecromancerFirstName2+
                                    " "+NecromancerLastName2+" rolls for "+
                                            randomNum1+
                                    ". "+randomNum1+" + "+
                                            NecromancerAccuracyStatInt+
                                    " Accuracy = "+
                                            necromancerAttackValue+" Attack");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }

                                //roll for Damage
                                else if(userRollChoice == 2)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum2;

                                    /*random # between 1-1000*/
                                    randomNum2 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int necromancerDamageValue = 
                                    necromancerDamage.rollForDamage(randomNum2,
                                            NecromancerAttackStatInt);

                                    System.out.println(NecromancerFirstName2+
                                    " "+NecromancerLastName2+" rolls for "+
                                            randomNum2+
                                    ". "+randomNum2+" + "+
                                            NecromancerAttackStatInt+
                                    " Attack = "
                                            +necromancerDamageValue+" Damage");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }

                                //roll for Physical Defense
                                else if(userRollChoice == 3)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum3;

                                    /*random # between 1-1000*/
                                    randomNum3 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int necromancerPhyDefValue = 
                                    necromancerPhyDef.rollForPhyDef(randomNum3,
                                            NecromancerPhyDefStatInt);

                                    System.out.println(NecromancerFirstName2+
                                    " "+NecromancerLastName2+" rolls for "+
                                            randomNum3+
                                    ". "+randomNum3+" + "+
                                            NecromancerPhyDefStatInt+
                                    " Physical Defense = "+
                                            necromancerPhyDefValue+
                                            " Physical Defense");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }

                                //roll for Magical Defense
                                else if(userRollChoice == 4)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum4;

                                    /*random # between 1-1000*/
                                    randomNum4 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int necromancerMagDefValue = 
                                    necromancerMagDef.rollForMagDef(randomNum4,
                                            NecromancerMagDefStatInt);

                                    System.out.println(NecromancerFirstName2+
                                    " "+NecromancerLastName2+" rolls for "+
                                            randomNum4+
                                    ". "+randomNum4+" + "+
                                            NecromancerMagDefStatInt+
                                    " Magical Defense = "+
                                            necromancerMagDefValue+
                                            " Magical Defense");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }
                            }

                            //if the currently selected character is a Wizard
                            else if(selectedCharacterClass.contains(thisIsWizard))
                            {

                                // START: Get Wizard Accuracy Stat value
                                //----------------------------------------------

                                int WizardAccuracyStatInt;

                                /*turn the String WizardAccuracyStat into int data
                                type so that the value can be used in methods that
                                require the value to be of int type*/
                                WizardAccuracyStatInt = 
                                        Integer.valueOf(WizardAccuracyStat);

                                //END: Got Wizard Accuracy Stat value
                                //----------------------------------------------

                                /* START: Get Wizard getAttack object &
                                Attack Stat value*/
                                //----------------------------------------------

                                getAttack wizardAttack = new getAttack();

                                int WizardAttackStatInt;

                                /*turn the String WizardAttackStat into int data
                                type so that the value can be used in methods that
                                require the value to be of int type*/
                                WizardAttackStatInt = 
                                        Integer.valueOf(WizardAttackStat);

                                /*END: Got Wizard getAttack object &
                                Attack Stat value*/
                                //----------------------------------------------

                                // START: Get Wizard getDamage object
                                //----------------------------------------------

                                getDamage wizardDamage = new getDamage();

                                //END: Got Wizard getDamage object
                                //----------------------------------------------

                                /* START: Get Wizard getPhyDef object &
                                Physical Defense Stat value*/
                                //----------------------------------------------

                                getPhyDef wizardPhyDef = new getPhyDef();

                                int WizardPhyDefStatInt;

                                /*turn the String WizardPhyDefStat into int data
                                type so that the value can be used in methods that
                                require the value to be of int type*/
                                WizardPhyDefStatInt = Integer.
                                        valueOf(WizardPhyDefStat);

                                /*END: Got Wizard getPhyDef object &
                                PhyDef Stat value*/
                                //----------------------------------------------

                                /* START: Get Wizard getMagDef object &
                                Magical Defense Stat value*/
                                //----------------------------------------------

                                getMagDef wizardMagDef = new getMagDef();

                                int WizardMagDefStatInt;

                                /*turn the String WizardMagDefStat into int data
                                type so that the value can be used in methods that
                                require the value to be of int type*/
                                WizardMagDefStatInt = 
                                        Integer.valueOf(WizardMagDefStat);

                                /*END: Got Wizard getMagDef object &
                                MagDef Stat value*/
                                //----------------------------------------------



                                //roll for attack
                                if(userRollChoice == 1)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum1;

                                    /*random # between 1-1000*/
                                    randomNum1 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int wizardAttackValue = 
                                    wizardAttack.rollForAttack(randomNum1,
                                            WizardAccuracyStatInt);

                                    System.out.println(WizardFirstName2+
                                    " "+WizardLastName2+" rolls for "+randomNum1+
                                    ". "+randomNum1+" + "+WizardAccuracyStatInt+
                                    " Accuracy = "+wizardAttackValue+" Attack");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }

                                //roll for Damage
                                else if(userRollChoice == 2)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum2;

                                    /*random # between 1-1000*/
                                    randomNum2 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int wizardDamageValue = 
                                    wizardDamage.rollForDamage(randomNum2,
                                            WizardAttackStatInt);

                                    System.out.println(WizardFirstName2+
                                    " "+WizardLastName2+" rolls for "+randomNum2+
                                    ". "+randomNum2+" + "+WizardAttackStatInt+
                                    " Attack = "+wizardDamageValue+" Damage");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }

                                //roll for Physical Defense
                                else if(userRollChoice == 3)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum3;

                                    /*random # between 1-1000*/
                                    randomNum3 = generator.nextInt(rangeInt2)+rangeInt1;

                                    int wizardPhyDefValue = 
                                    wizardPhyDef.rollForPhyDef(randomNum3,
                                            WizardPhyDefStatInt);

                                    System.out.println(WizardFirstName2+
                                    " "+WizardLastName2+" rolls for "+randomNum3+
                                    ". "+randomNum3+" + "+WizardPhyDefStatInt+
                                    " Physical Defense = "+wizardPhyDefValue+" Physical Defense");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }

                                //roll for Magical Defense
                                else if(userRollChoice == 4)
                                {
                                    File rangeText = new File("src/range.txt");
                                    Scanner scanRange = new Scanner(rangeText);
                                    int rangeInt1 = scanRange.nextInt();//1
                                    int rangeInt2 = scanRange.nextInt();//1000
                                    Random generator = new Random();

                                    //random number that user will roll for
                                    int randomNum4;

                                    /*random # between 1-1000*/
                                    randomNum4 = generator.
                                            nextInt(rangeInt2)+rangeInt1;

                                    int wizardMagDefValue = 
                                    wizardMagDef.rollForMagDef(randomNum4,
                                            WizardMagDefStatInt);

                                    System.out.println(WizardFirstName2+
                                    " "+WizardLastName2+" rolls for "+randomNum4+
                                    ". "+randomNum4+" + "+WizardMagDefStatInt+
                                    " Magical Defense = "+
                                            wizardMagDefValue+" Magical Defense");
                                    System.out.print("Press enter to continue.");
                                    try{System.in.read();}
                                    catch(Exception e){}
                                    System.out.println();
                                    System.out.println();
                                }
                            }

                            System.out.println("Perform an action");
                            System.out.println("--------------------");
                            System.out.println("1. Roll for Attack\n"+
                            "2. Roll for Damage\n"+
                            "3. Roll for Physical Defense\n"+
                            "4. Roll for Magical Defense\n"+
                            "5. Return to main menu");
                            System.out.println();
                            System.out.print("Enter your roll choice: ");
                            userRollChoice = scan.nextInt();
                            System.out.println();
                            System.out.println();
                        }
                    }
                }
                
                /*For when the user has yet to either create, select, or load
                a character from a save file*/
                catch(FileNotFoundException exception)
                {
                    System.out.print("To perform an action you must either"+
                    " create a character, select an existing character,\nor"+
                    " load a character from a save file."+
                    " Press enter to continue.");
                    try{System.in.read();}
                    catch(Exception e){}
                    System.out.println();
                    System.out.println();
                }
            }
     
            //conditionals for Character Manager menu while loop
            if(selectedCharacter.isEmpty())
            {
                System.out.println("Character Manager");
                System.out.println("-----------------------");
                System.out.print("You have no character selected."+
                " Enter 1 to create a"+
                " new character, 2 to select an existing character, \n"+
                "3 to load a character from file, 4 to save a character to file,"+
                " 5 to perform an action, or 6 to exit: ");
                userMainMenu = scan.nextInt();
                System.out.println();
                System.out.println();
            }
            
            //if the user does have a character selected
            else
            {
                
                
                //START: Get Assassin Character Name
                //--------------------------------------------------------------
                //will retrieve AssassinFirstName.txt
                File Assassin1stFile = new File("src/AssassinFirstName.txt");
                Scanner scanAssassinFirstName = new Scanner(Assassin1stFile);

                //will retrieve AssassinLastName.txt
                File Assassin2ndFile = new File("src/AssassinLastName.txt");
                Scanner scanAssassinLastName = new Scanner(Assassin2ndFile);

                //read the AssassinFirstName.txt file & AssassinLastName.txt file
                String AssassinFirstNameTxt = scanAssassinFirstName.next();
                String AssassinLastNameTxt = scanAssassinLastName.next();
                //END
                //--------------------------------------------------------------

                //START: Get Engineeer Character Name
                //--------------------------------------------------------------
                //will retrieve EngineerFirstName.txt
                File Engineer1stFile = new File("src/EngineerFirstName.txt");
                Scanner scanEngineerFirstName = new Scanner(Engineer1stFile);

                //will retrieve EngineerLastName.txt
                File Engineer2ndFile = new File("src/EngineerLastName.txt");
                Scanner scanEngineerLastName = new Scanner(Engineer2ndFile);

                //read the EngineerFirstName.txt file & EngineerLastName.txt file
                String EngineerFirstNameTxt = scanEngineerFirstName.next();
                String EngineerLastNameTxt = scanEngineerLastName.next();
                //END
                //--------------------------------------------------------------

                //START: Get Healer Character Name
                //--------------------------------------------------------------
                //will retrieve HealerFirstName.txt
                File Healer1stFile = new File("src/HealerFirstName.txt");
                Scanner scanHealerFirstName = new Scanner(Healer1stFile);

                //will retrieve HealerLastName.txt
                File Healer2ndFile = new File("src/HealerLastName.txt");
                Scanner scanHealerLastName = new Scanner(Healer2ndFile);

                //read the HealerFirstName.txt file & HealerLastName.txt file
                String HealerFirstNameTxt = scanHealerFirstName.next();
                String HealerLastNameTxt = scanHealerLastName.next();
                //END
                //--------------------------------------------------------------

                //START: Get Martial Artist Character Name
                //--------------------------------------------------------------
                //will retrieve MartialArtistFirstName.txt
                File MartialArtist1stFile = 
                        new File("src/MartialArtistFirstName.txt");
                Scanner scanMartialArtistFirstName = 
                        new Scanner(MartialArtist1stFile);

                //will retrieve MartialArtistLastName.txt
                File MartialArtist2ndFile = 
                        new File("src/MartialArtistLastName.txt");
                Scanner scanMartialArtistLastName = 
                        new Scanner(MartialArtist2ndFile);

                /*read the MartialArtistFirstName.txt file &
                MartialArtistLastName.txt file*/
                String MartialArtistFirstNameTxt = 
                        scanMartialArtistFirstName.next();
                String MartialArtistLastNameTxt = 
                        scanMartialArtistLastName.next();
                //END
                //--------------------------------------------------------------

                //START: Get Necromancer Character Name
                //--------------------------------------------------------------
                //will retrieve NecromancerFirstName.txt
                File Necromancer1stFile = new File("src/NecromancerFirstName.txt");
                Scanner scanNecromancerFirstName = new Scanner(Necromancer1stFile);

                //will retrieve NecromancerLastName.txt
                File Necromancer2ndFile = new File("src/NecromancerLastName.txt");
                Scanner scanNecromancerLastName = new Scanner(Necromancer2ndFile);

                /*read the NecromancerFirstName.txt file &
                NecromancerLastName.txt file*/
                String NecromancerFirstNameTxt = scanNecromancerFirstName.next();
                String NecromancerLastNameTxt = scanNecromancerLastName.next();
                //END
                //--------------------------------------------------------------

                //START: Get Wizard Character Name
                //--------------------------------------------------------------
                //will retrieve WizardFirstName.txt
                File Wizard1stFile = new File("src/WizardFirstName.txt");
                Scanner scanWizardFirstName = new Scanner(Wizard1stFile);

                //will retrieve WizardLastName.txt
                File Wizard2ndFile = new File("src/WizardLastName.txt");
                Scanner scanWizardLastName = new Scanner(Wizard2ndFile);

                //read the WizardFirstName.txt file & WizardLastName.txt file
                String WizardFirstNameTxt = scanWizardFirstName.next();
                String WizardLastNameTxt = scanWizardLastName.next();
                //END
                //--------------------------------------------------------------

                /*if the selectedCharacterClass contains the #1 (thisIsAssassin)
                representing a character of the Assassin Class, then let the user
                know they have said character selected be displaying it*/
                if(selectedCharacterClass.contains(thisIsAssassin))
                {
                    System.out.println("Character Manager");
                    System.out.println("-----------------------");
                    System.out.print("You have \""+AssassinFirstNameTxt+" "+
                    AssassinLastNameTxt+"\" the Assassin selected. Enter 1 to"+
                    " create a new character, 2 to select an existing chara"+
                    "cter,\n3 to load a character from file, 4 to save a"+
                    " character to file, 5 to perform an action, or 6 to exit: ");
                    userMainMenu = scan.nextInt();
                    System.out.println();
                    System.out.println();
                }

                /*if the selectedCharacterClass contains the #2 (thisIsEngineer)
                representing a character of the Engineer Class, then let the user
                know they have said character selected by displaying it*/
                else if(selectedCharacterClass.contains(thisIsEngineer))
                {
                    System.out.println("Character Manager");
                    System.out.println("-----------------------");
                    System.out.print("You have \""+EngineerFirstNameTxt+" "+
                    EngineerLastNameTxt+"\" the Engineer selected. Enter 1 to"+
                    " create a new character, 2 to select an existing chara"+
                    "cter,\n3 to load a character from file, 4 to save a"+
                    " character to file, 5 to perform an action, or 6 to exit: ");
                    userMainMenu = scan.nextInt();
                    System.out.println();
                    System.out.println();
                }

                /*if the selectedCharacterClass contains the #3 (thisIsHealer)
                representing a character of the Healer Class, then let the user
                know they have said character selected by displaying it*/
                else if(selectedCharacterClass.contains(thisIsHealer))
                {
                    System.out.println("Character Manager");
                    System.out.println("-----------------------");
                    System.out.print("You have \""+HealerFirstNameTxt+" "+
                    HealerLastNameTxt+"\" the Healer selected. Enter 1 to"+
                    " create a new character, 2 to select an existing chara"+
                    "cter,\n3 to load a character from file, 4 to save a"+
                    " character to file, 5 to perform an action, or 6 to exit: ");
                    userMainMenu = scan.nextInt();
                    System.out.println();
                    System.out.println();
                }

                /*if the selectedCharacterClass contains the #4 
                (thisIsMartialArtist) representing a character of the Martial
                Artist Class, then let the user know they have said character
                selected by displaying it*/
                else if(selectedCharacterClass.contains(thisIsMartialArtist))
                {
                    System.out.println("Character Manager");
                    System.out.println("-----------------------");
                    System.out.print("You have \""+MartialArtistFirstNameTxt+" "+
                    MartialArtistLastNameTxt+"\" the Martial Artist selected. Enter 1 to"+
                    " create a new character, 2 to select an existing chara"+
                    "cter,\n3 to load a character from file, 4 to save a"+
                    " character to file, 5 to perform an action, or 6 to exit: ");
                    userMainMenu = scan.nextInt();
                    System.out.println();
                    System.out.println();
                }

                /*if the selectedCharacterClass contains the #5 (thisIsNecromancer)
                representing a character of the Necromancer Class, then let the
                user
                know they have said character selected by displaying it*/
                else if(selectedCharacterClass.contains(thisIsNecromancer))
                {
                    System.out.println("Character Manager");
                    System.out.println("-----------------------");
                    System.out.print("You have \""+NecromancerFirstNameTxt+" "+
                    NecromancerLastNameTxt+"\" the Necromancer selected. Enter 1 to"+
                    " create a new character, 2 to select an existing chara"+
                    "cter,\n3 to load a character from file, 4 to save a"+
                    " character to file, 5 to perform an action, or 6 to exit: ");
                    userMainMenu = scan.nextInt();
                    System.out.println();
                    System.out.println();
                }

                /*if the selectedCharacterClass contains the #6 (thisIsWizard)
                representing a character of the Wizard Class, then let the user
                know they have said character selected by displaying it*/
                else if(selectedCharacterClass.contains(thisIsWizard))
                {
                    System.out.println("Character Manager");
                    System.out.println("-----------------------");
                    System.out.print("You have \""+WizardFirstNameTxt+" "+
                    WizardLastNameTxt+"\" the Wizard selected. Enter 1 to"+
                    " create a new character, 2 to select an existing chara"+
                    "cter,\n3 to load a character from file, 4 to save a"+
                    " character to file, 5 to perform an action, or 6 to exit: ");
                    userMainMenu = scan.nextInt();
                    System.out.println();
                    System.out.println();
                }
            }    
        }
    }
}



