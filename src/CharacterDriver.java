
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
    public int accuracyStat(int randomAccuracyStat);/*the randomAccuracyStat value will be the random number that
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

class Wizard/*They can manipulate the natural elements of the earth and beyond, confuse their opponents, and, if powerful enough,
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
        
        /*Linked list that holds characters that have been created and/or
        characters that have been loaded from a save file. And the strings are
        what hold the user-entered character names of their created characters/ 
        characters loaded from a save file.*/
        LinkedList loadedCharacters = new LinkedList();
        String AssassinFirstName;
        String AssassinLastName;
        
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
        
        /*this list holds characters that are currently selected. Currently selected 
        characters are also present in the loadedCharacters list, but the difference
        between a loaded character and a selected one is that a selected character
        can actually be used by the user since it is the current character in
        use, while the other characters in the loadedCharacters list are just in
        saved files/memory.   */
        LinkedList selectedCharacter = new LinkedList();
        
        /*this list will hold only 1 int value at a time. The value of said int
        will be used to determine the class of a created and/or loaded character
        so that the correct class can be used for the correct character when
        using the rolling methods (option #5 of the Character Manager Menu).
        This needs to happen because each class has different max potential stat
        values. For example, the healer will not do as much damage as the Martial
        Artist so the user needs to be able to use the correct class for their
        character.*/
        ArrayList<Integer> selectedCharacterClass = new ArrayList();
        
        //these values are added to the above array for the above mentioned reason
        int thisIsAssassin = 1;
        int thisIsEngineer = 2;
        int thisIsHealer = 3;
        int thisIsMartialArtist = 4;
        int thisIsNecromancer = 5;
        int thisIsWizard = 6;
        
        //----------------------------------------------------------------------
        //Program starts below, everything above is used later in the program
        
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
                        " small,\nbig, and humongous- to do their bidding. They"+
                        " can take the life force from the living to heal\nthemselves.");
                        
                        System.out.println();
                        
                        System.out.println("Wizard: They can manipulate the"+
                        " natural elements of the earth and beyond, confuse"+
                        " their\nopponents, and, if powerful enough, seal their"+
                        " opponents in another dimension.");
                        
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
           
                        /*range.txt holds the numbers in the range of 1-500 so
                        that it can be read from to provide random numbers in
                        said range so that in character creation the user can
                        pick 5 of said random numbers to be used for their 
                        5 stats (Accuracy, Attack, Damage, Physical Defense,
                        and Magical Defense).*/
                        File rangeText = new File("src/range.txt");
                        Scanner scanRange = new Scanner(rangeText);
                        int rangeInt1 = scanRange.nextInt();//1
                        int rangeInt2 = scanRange.nextInt();//500
                        Random generator = new Random();
                    
                        int randomNum1;
                        int randomNum2;
                        int randomNum3;
                        int randomNum4;
                        int randomNum5;
                        
                        /*random # between 1-500*/
                        randomNum1 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum2 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum3 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum4 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum5 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*the above random num values are later stored in these 
                        variables below so that the user can select from randomly 
                        generated stat values for each stat which will then be 
                        written to a txt file so that its value can be read/
                        loaded later on*/
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
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                            FileWriter writeStats = new FileWriter("src/AssassinFirstName.txt");
                            writeStats.write(String.valueOf(AssassinFirstName));
                            writeStats.close();
                            
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Assassin the currently selected character
                        //if both lists are empty...add AssassinFirstName then add thisIsAssassin (value 1)
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
                        
                        System.out.print("Enter the last name of your Assassin character: ");
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
                            FileWriter writeStats = new FileWriter("src/AssassinLastName.txt");
                            writeStats.write(String.valueOf(AssassinLastName));
                            writeStats.close();
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Assassin the currently selected character
                        //if selectedCharacter contains AssassinFirstName...add AssassinLastName 
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
                        /*range.txt holds the numbers in the range of 1-500 so
                        that it can be read from to provide random numbers in
                        said range so that in character creation the user can
                        pick 5 of said random numbers to be used for their 
                        5 stats (Accuracy, Attack, Damage, Physical Defense,
                        and Magical Defense).*/
                        File rangeText = new File("src/range.txt");
                        Scanner scanRange = new Scanner(rangeText);
                        int rangeInt1 = scanRange.nextInt();//1
                        int rangeInt2 = scanRange.nextInt();//500
                        Random generator = new Random();
                    
                        int randomNum1;
                        int randomNum2;
                        int randomNum3;
                        int randomNum4;
                        int randomNum5;
                        
                        /*random # between 1-500*/
                        randomNum1 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum2 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum3 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum4 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum5 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*the above random num values are later stored in these 
                        variables below so that the user can select from randomly 
                        generated stat values for each stat which will then be 
                        written to a txt file so that its value can be read/
                        loaded later on*/
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
                        
                        //Accuracy Stat if statements for Engineer class
                        if(accuracyStatChoice.equals("a") || accuracyStatChoice.equals("A"))
                        {
                            randomAccuracyStat = randomNum1;
                            try
                            {
                                FileWriter writeStats = new FileWriter("src/EngineerAccuracyStat.txt");
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
                                FileWriter writeStats = new FileWriter("src/EngineerAccuracyStat.txt");
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
                                FileWriter writeStats = new FileWriter("src/EngineerAccuracyStat.txt");
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
                                FileWriter writeStats = new FileWriter("src/EngineerAccuracyStat.txt");
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
                                FileWriter writeStats = new FileWriter("src/EngineerAccuracyStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/EngineerAttackStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/EngineerAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    FileWriter writeStats = new FileWriter("src/EngineerAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    FileWriter writeStats = new FileWriter("src/EngineerAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    FileWriter writeStats = new FileWriter("src/EngineerAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    FileWriter writeStats = new FileWriter("src/EngineerDamageStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/EngineerDamageStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/EngineerDamageStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/EngineerDamageStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/EngineerDamageStat.txt");
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
                        
                        //Physical Defence Stat if statements for Engineer Class
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
                                    FileWriter writeStats = new FileWriter("src/EngineerPhyDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/EngineerPhyDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/EngineerPhyDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/EngineerPhyDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/EngineerPhyDefStat.txt");
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
                        
                        //Magical Defense Stat if statements for Engineer Class
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
                                    FileWriter writeStats = new FileWriter("src/EngineerMagDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/EngineerMagDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/EngineerMagDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/EngineerMagDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/EngineerMagDefStat.txt");
                                    writeStats.write(String.valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        System.out.print("Enter the first name of your Engineer character: ");
                        EngineerFirstName = scan.next();//EngineerFirstName is "global"
                        
                        /*add character name variable "EngineerFirstName" to
                        loadedCharacters linked list to be accessed in other 
                        parts of the program (like selecting an existing 
                        character)*/
                        loadedCharacters.add(EngineerFirstName);/*linked list "loaded
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
                            FileWriter writeStats = new FileWriter("src/EngineerFirstName.txt");
                            writeStats.write(String.valueOf(EngineerFirstName));
                            writeStats.close();
                            
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Engineer the currently selected character
                        //if both lists are empty...add EngineerFirstName then add thisIsEngineer (value 2)
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
                        
                        System.out.print("Enter the last name of your Engineer character: ");
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
                            FileWriter writeStats = new FileWriter("src/EngineerLastName.txt");
                            writeStats.write(String.valueOf(EngineerLastName));
                            writeStats.close();
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Engineer the currently selected character
                        //if selectedCharacter contains EngineerFirstName...add EngineerLastName 
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
                        /*range.txt holds the numbers in the range of 1-500 so
                        that it can be read from to provide random numbers in
                        said range so that in character creation the user can
                        pick 5 of said random numbers to be used for their 
                        5 stats (Accuracy, Attack, Damage, Physical Defense,
                        and Magical Defense).*/
                        File rangeText = new File("src/range.txt");
                        Scanner scanRange = new Scanner(rangeText);
                        int rangeInt1 = scanRange.nextInt();//1
                        int rangeInt2 = scanRange.nextInt();//500
                        Random generator = new Random();
                    
                        int randomNum1;
                        int randomNum2;
                        int randomNum3;
                        int randomNum4;
                        int randomNum5;
                        
                        /*random # between 1-500*/
                        randomNum1 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum2 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum3 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum4 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum5 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*the above random num values are later stored in these 
                        variables below so that the user can select from randomly 
                        generated stat values for each stat which will then be 
                        written to a txt file so that its value can be read/
                        loaded later on*/
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
                        
                        //Accuracy Stat if statements for Healer class
                        if(accuracyStatChoice.equals("a") || accuracyStatChoice.equals("A"))
                        {
                            randomAccuracyStat = randomNum1;
                            try
                            {
                                FileWriter writeStats = new FileWriter("src/HealerAccuracyStat.txt");
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
                                FileWriter writeStats = new FileWriter("src/HealerAccuracyStat.txt");
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
                                FileWriter writeStats = new FileWriter("src/HealerAccuracyStat.txt");
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
                                FileWriter writeStats = new FileWriter("src/HealerAccuracyStat.txt");
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
                                FileWriter writeStats = new FileWriter("src/HealerAccuracyStat.txt");
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
                        
                        //Attack Stat if statements for Healer Class
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
                                    FileWriter writeStats = new FileWriter("src/HealerAttackStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/HealerAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    FileWriter writeStats = new FileWriter("src/HealerAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    FileWriter writeStats = new FileWriter("src/HealerAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    FileWriter writeStats = new FileWriter("src/HealerAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    FileWriter writeStats = new FileWriter("src/HealerDamageStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/HealerDamageStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/HealerDamageStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/HealerDamageStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/HealerDamageStat.txt");
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
                        
                        //Physical Defence Stat if statements for Healer Class
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
                                    FileWriter writeStats = new FileWriter("src/HealerPhyDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/HealerPhyDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/HealerPhyDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/HealerPhyDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/HealerPhyDefStat.txt");
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
                        
                        //Magical Defense Stat if statements for Healer Class
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
                                    FileWriter writeStats = new FileWriter("src/HealerMagDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/HealerMagDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/HealerMagDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/HealerMagDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/HealerMagDefStat.txt");
                                    writeStats.write(String.valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        
                        System.out.print("Enter the first name of your Healer character: ");
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
                            FileWriter writeStats = new FileWriter("src/HealerFirstName.txt");
                            writeStats.write(String.valueOf(HealerFirstName));
                            writeStats.close();
                            
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Healer the currently selected character
                        //if both lists are empty...add HealerFirstName then add thisIsHealer (value 3)
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
                        
                        System.out.print("Enter the last name of your Healer character: ");
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
                            FileWriter writeStats = new FileWriter("src/HealerLastName.txt");
                            writeStats.write(String.valueOf(HealerLastName));
                            writeStats.close();
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Healer the currently selected character
                        //if selectedCharacter contains HealerFirstName...add HealerLastName 
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
                        /*range.txt holds the numbers in the range of 1-500 so
                        that it can be read from to provide random numbers in
                        said range so that in character creation the user can
                        pick 5 of said random numbers to be used for their 
                        5 stats (Accuracy, Attack, Damage, Physical Defense,
                        and Magical Defense).*/
                        File rangeText = new File("src/range.txt");
                        Scanner scanRange = new Scanner(rangeText);
                        int rangeInt1 = scanRange.nextInt();//1
                        int rangeInt2 = scanRange.nextInt();//500
                        Random generator = new Random();
                    
                        int randomNum1;
                        int randomNum2;
                        int randomNum3;
                        int randomNum4;
                        int randomNum5;
                        
                        /*random # between 1-500*/
                        randomNum1 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum2 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum3 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum4 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum5 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*the above random num values are later stored in these 
                        variables below so that the user can select from randomly 
                        generated stat values for each stat which will then be 
                        written to a txt file so that its value can be read/
                        loaded later on*/
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
                        
                        //Accuracy Stat if statements for Martial Artist class
                        if(accuracyStatChoice.equals("a") || accuracyStatChoice.equals("A"))
                        {
                            randomAccuracyStat = randomNum1;
                            try
                            {
                                FileWriter writeStats = new FileWriter("src/MartialArtistAccuracyStat.txt");
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
                                FileWriter writeStats = new FileWriter("src/MartialArtistAccuracyStat.txt");
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
                                FileWriter writeStats = new FileWriter("src/MartialArtistAccuracyStat.txt");
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
                                FileWriter writeStats = new FileWriter("src/MartialArtistAccuracyStat.txt");
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
                                FileWriter writeStats = new FileWriter("src/MartialArtistAccuracyStat.txt");
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
                        
                        //Attack Stat if statements for Martial Artist Class
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
                                    FileWriter writeStats = new FileWriter("src/MartialArtistAttackStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/MartialArtistAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    FileWriter writeStats = new FileWriter("src/MartialArtistAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    FileWriter writeStats = new FileWriter("src/MartialArtistAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    FileWriter writeStats = new FileWriter("src/MartialArtistAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    FileWriter writeStats = new FileWriter("src/MartialArtistDamageStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/MartialArtistDamageStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/MartialArtistDamageStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/MartialArtistDamageStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/MartialArtistDamageStat.txt");
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
                        
                        //Physical Defence Stat if statements for Martial Artist Class
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
                                    FileWriter writeStats = new FileWriter("src/MartialArtistPhyDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/MartialArtistPhyDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/MartialArtistPhyDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/MartialArtistPhyDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/MartialArtistPhyDefStat.txt");
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
                        
                        //Magical Defense Stat if statements for Martial Artist Class
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
                                    FileWriter writeStats = new FileWriter("src/MartialArtistMagDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/MartialArtistMagDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/MartialArtistMagDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/MartialArtistMagDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/MartialArtistMagDefStat.txt");
                                    writeStats.write(String.valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        
                        System.out.print("Enter the first name of your Martial Artist character: ");
                        MartialArtistFirstName = scan.next();//MartialArtistFirstName is "global"
                        
                        /*add character name variable "MartialArtistFirstName" to
                        loadedCharacters linked list to be accessed in other 
                        parts of the program (like selecting an existing 
                        character)*/
                        loadedCharacters.add(MartialArtistFirstName);/*linked list "loaded
                        characters" is "global"*/
                        
                        try//write MartialArtistFirstName to MartialArtistFirstName.txt file
                        {
                            /*MartialArtistFirstName and MartialArtistFirstName.txt can only
                            store one Martial Artist character's First name, so the newly
                            created character's first name must be written to this txt
                            file which will later be read so that said character
                            name can be written to another file(which the user
                            will name and said txt file will also contain all of
                            the Martial Artist Character's stats) after being created,
                            otherwise upon creating another Martial Artist character,
                            the previously created one will be overwritten by
                            the newer one.*/
                            FileWriter writeStats = new FileWriter("src/MartialArtistFirstName.txt");
                            writeStats.write(String.valueOf(MartialArtistFirstName));
                            writeStats.close();
                            
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Martial Artist the currently selected character
                        //if both lists are empty...add MartialArtistFirstName then add thisIsMartialArtist (value 4)
                        if(selectedCharacter.isEmpty())
                        {
                            selectedCharacter.add(MartialArtistFirstName);
                            
                            if(selectedCharacterClass.isEmpty())
                            {
                                /*values that are added to the selectedCharacterClass
                                list are added after the first name of a character
                                is added to the selectedCharacter list.*/
                                selectedCharacterClass.add(thisIsMartialArtist);
                                
                            }
                            
                        }
                        /*If not empty then clear it to make way for the Martial Artist
                        Character to be the currently selected character. And
                        make way for the selectedCharacterClass to add the correct
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
                        
                        System.out.print("Enter the last name of your Martial Artist character: ");
                        MartialArtistLastName = scan.next();//MartialArtistLastName is "global"
                        
                        /*add character name variable "MartialArtistLastName" to
                        loadedCharacters linked list to be accessed in other 
                        parts of the program (like selecting an existing 
                        character)*/
                        loadedCharacters.add(MartialArtistLastName);/*linked list "loaded
                        characters" is "global"*/
                        
                        try//write MartialArtistLastName to MartialArtistLastName.txt file
                        {
                            /*MartialArtistLastName and MartialArtistLastName.txt can only
                            store one Martial Artist character's last name, so the newly
                            created character's name must be written to this txt
                            file which will later be read so that said character
                            name can be written to another file(which the user
                            will name and said txt file will also contain all of
                            the Martial Artist Character's stats) after being created,
                            otherwise upon creating another Martial Artist character,
                            the previously created one will be overwritten by
                            the newer one.*/
                            FileWriter writeStats = new FileWriter("src/MartialArtistLastName.txt");
                            writeStats.write(String.valueOf(MartialArtistLastName));
                            writeStats.close();
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Martial Artist the currently selected character
                        //if selectedCharacter contains MartialArtistFirstName...add MartialArtistLastName 
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
                        /*range.txt holds the numbers in the range of 1-500 so
                        that it can be read from to provide random numbers in
                        said range so that in character creation the user can
                        pick 5 of said random numbers to be used for their 
                        5 stats (Accuracy, Attack, Damage, Physical Defense,
                        and Magical Defense).*/
                        File rangeText = new File("src/range.txt");
                        Scanner scanRange = new Scanner(rangeText);
                        int rangeInt1 = scanRange.nextInt();//1
                        int rangeInt2 = scanRange.nextInt();//500
                        Random generator = new Random();
                    
                        int randomNum1;
                        int randomNum2;
                        int randomNum3;
                        int randomNum4;
                        int randomNum5;
                        
                        /*random # between 1-500*/
                        randomNum1 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum2 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum3 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum4 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum5 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*the above random num values are later stored in these 
                        variables below so that the user can select from randomly 
                        generated stat values for each stat which will then be 
                        written to a txt file so that its value can be read/
                        loaded later on*/
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
                        
                        //Accuracy Stat if statements for Necromancer class
                        if(accuracyStatChoice.equals("a") || accuracyStatChoice.equals("A"))
                        {
                            randomAccuracyStat = randomNum1;
                            try
                            {
                                FileWriter writeStats = new FileWriter("src/NecromancerAccuracyStat.txt");
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
                                FileWriter writeStats = new FileWriter("src/NecromancerAccuracyStat.txt");
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
                                FileWriter writeStats = new FileWriter("src/NecromancerAccuracyStat.txt");
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
                                FileWriter writeStats = new FileWriter("src/NecromancerAccuracyStat.txt");
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
                                FileWriter writeStats = new FileWriter("src/NecromancerAccuracyStat.txt");
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
                        
                        //Attack Stat if statements for Necromancer Class
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
                                    FileWriter writeStats = new FileWriter("src/NecromancerAttackStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/NecromancerAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    FileWriter writeStats = new FileWriter("src/NecromancerAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    FileWriter writeStats = new FileWriter("src/NecromancerAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    FileWriter writeStats = new FileWriter("src/NecromancerAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    FileWriter writeStats = new FileWriter("src/NecromancerDamageStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/NecromancerDamageStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/NecromancerDamageStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/NecromancerDamageStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/NecromancerDamageStat.txt");
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
                        
                        //Physical Defence Stat if statements for Necromancer Class
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
                                    FileWriter writeStats = new FileWriter("src/NecromancerPhyDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/NecromancerPhyDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/NecromancerPhyDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/NecromancerPhyDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/NecromancerPhyDefStat.txt");
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
                        
                        //Magical Defense Stat if statements for Necromancer Class
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
                                    FileWriter writeStats = new FileWriter("src/NecromancerMagDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/NecromancerMagDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/NecromancerMagDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/NecromancerMagDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/NecromancerMagDefStat.txt");
                                    writeStats.write(String.valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        
                        System.out.print("Enter the first name of your Necromancer character: ");
                        NecromancerFirstName = scan.next();//NecromancerFirstName is "global"
                        
                        /*add character name variable "NecromancerFirstName" to
                        loadedCharacters linked list to be accessed in other 
                        parts of the program (like selecting an existing 
                        character)*/
                        loadedCharacters.add(NecromancerFirstName);/*linked list "loaded
                        characters" is "global"*/
                        
                        try//write NecromancerFirstName to NecromancerFirstName.txt file
                        {
                            /*NecromancerFirstName and NecromancerFirstName.txt can only
                            store one Necromancer character's First name, so the newly
                            created character's first name must be written to this txt
                            file which will later be read so that said character
                            name can be written to another file(which the user
                            will name and said txt file will also contain all of
                            the Necromancer Character's stats) after being created,
                            otherwise upon creating another Necromancer character,
                            the previously created one will be overwritten by
                            the newer one.*/
                            FileWriter writeStats = new FileWriter("src/NecromancerFirstName.txt");
                            writeStats.write(String.valueOf(NecromancerFirstName));
                            writeStats.close();
                            
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Necromancer the currently selected character
                        //if both lists are empty...add NecromancerFirstName then add thisIsNecromancer (value 5)
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
                        
                        System.out.print("Enter the last name of your Necromancer character: ");
                        NecromancerLastName = scan.next();//NecromancerLastName is "global"
                        
                        /*add character name variable "NecromancerLastName" to
                        loadedCharacters linked list to be accessed in other 
                        parts of the program (like selecting an existing 
                        character)*/
                        loadedCharacters.add(NecromancerLastName);/*linked list "loaded
                        characters" is "global"*/
                        
                        try//write NecromancerLastName to NecromancerLastName.txt file
                        {
                            /*NecromancerLastName and NecromancerLastName.txt can only
                            store one Necromancer character's last name, so the newly
                            created character's name must be written to this txt
                            file which will later be read so that said character
                            name can be written to another file(which the user
                            will name and said txt file will also contain all of
                            the Necromancer Character's stats) after being created,
                            otherwise upon creating another Necromancer character,
                            the previously created one will be overwritten by
                            the newer one.*/
                            FileWriter writeStats = new FileWriter("src/NecromancerLastName.txt");
                            writeStats.write(String.valueOf(NecromancerLastName));
                            writeStats.close();
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }

                        //make the Necromancer the currently selected character
                        //if selectedCharacter contains NecromancerFirstName...add NecromancerLastName 
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
                        /*range.txt holds the numbers in the range of 1-500 so
                        that it can be read from to provide random numbers in
                        said range so that in character creation the user can
                        pick 5 of said random numbers to be used for their 
                        5 stats (Accuracy, Attack, Damage, Physical Defense,
                        and Magical Defense).*/
                        File rangeText = new File("src/range.txt");
                        Scanner scanRange = new Scanner(rangeText);
                        int rangeInt1 = scanRange.nextInt();//1
                        int rangeInt2 = scanRange.nextInt();//500
                        Random generator = new Random();
                    
                        int randomNum1;
                        int randomNum2;
                        int randomNum3;
                        int randomNum4;
                        int randomNum5;
                        
                        /*random # between 1-500*/
                        randomNum1 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum2 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum3 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum4 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*random # between 1-500*/
                        randomNum5 = generator.nextInt(rangeInt2)+rangeInt1;
                        
                        /*the above random num values are later stored in these 
                        variables below so that the user can select from randomly 
                        generated stat values for each stat which will then be 
                        written to a txt file so that its value can be read/
                        loaded later on*/
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
                        
                        //Accuracy Stat if statements for Wizard class
                        if(accuracyStatChoice.equals("a") || accuracyStatChoice.equals("A"))
                        {
                            randomAccuracyStat = randomNum1;
                            try
                            {
                                FileWriter writeStats = new FileWriter("src/WizardAccuracyStat.txt");
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
                                FileWriter writeStats = new FileWriter("src/WizardAccuracyStat.txt");
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
                                FileWriter writeStats = new FileWriter("src/WizardAccuracyStat.txt");
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
                                FileWriter writeStats = new FileWriter("src/WizardAccuracyStat.txt");
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
                                FileWriter writeStats = new FileWriter("src/WizardAccuracyStat.txt");
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
                        
                        //Attack Stat if statements for Wizard Class
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
                                    FileWriter writeStats = new FileWriter("src/WizardAttackStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/WizardAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    FileWriter writeStats = new FileWriter("src/WizardAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    FileWriter writeStats = new FileWriter("src/WizardAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    FileWriter writeStats = new FileWriter("src/WizardAttackStat.txt");
                                    writeStats.write(String.valueOf(randomAttackStat));
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
                                    FileWriter writeStats = new FileWriter("src/WizardDamageStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/WizardDamageStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/WizardDamageStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/WizardDamageStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/WizardDamageStat.txt");
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
                        
                        //Physical Defence Stat if statements for Wizard Class
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
                                    FileWriter writeStats = new FileWriter("src/WizardPhyDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/WizardPhyDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/WizardPhyDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/WizardPhyDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/WizardPhyDefStat.txt");
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
                        
                        //Magical Defense Stat if statements for Wizard Class
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
                                    FileWriter writeStats = new FileWriter("src/WizardMagDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/WizardMagDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/WizardMagDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/WizardMagDefStat.txt");
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
                                    FileWriter writeStats = new FileWriter("src/WizardMagDefStat.txt");
                                    writeStats.write(String.valueOf(randomMagDefStat));
                                    writeStats.close();
                                }
                                catch(IOException exception)
                                {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        
                        System.out.print("Enter the first name of your Wizard character: ");
                        WizardFirstName = scan.next();//WizardFirstName is "global"
                        
                        /*add character name variable "WizardFirstName" to
                        loadedCharacters linked list to be accessed in other 
                        parts of the program (like selecting an existing 
                        character)*/
                        loadedCharacters.add(WizardFirstName);/*linked list "loaded
                        characters" is "global"*/
                        
                        try//write WizardFirstName to WizardFirstName.txt file
                        {
                            /*WizardFirstName and WizardFirstName.txt can only
                            store one Wizard character's First name, so the newly
                            created character's first name must be written to this txt
                            file which will later be read so that said character
                            name can be written to another file(which the user
                            will name and said txt file will also contain all of
                            the Wizard Character's stats) after being created,
                            otherwise upon creating another Wizard character,
                            the previously created one will be overwritten by
                            the newer one.*/
                            FileWriter writeStats = new FileWriter("src/WizardFirstName.txt");
                            writeStats.write(String.valueOf(WizardFirstName));
                            writeStats.close();
                            
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Wizard the currently selected character
                        //if both lists are empty...add WizardFirstName then add thisIsWizard (value 6)
                        if(selectedCharacter.isEmpty())
                        {
                            selectedCharacter.add(WizardFirstName);
                            
                            if(selectedCharacterClass.isEmpty())
                            {
                                /*values that are added to the selectedCharacterClass
                                list are added after the first name of a character
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
                        
                        System.out.print("Enter the last name of your Wizard character: ");
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
                            FileWriter writeStats = new FileWriter("src/WizardLastName.txt");
                            writeStats.write(String.valueOf(WizardLastName));
                            writeStats.close();
                            
                        }
                        catch(IOException exception)
                        {
                            exception.printStackTrace();
                        }
                        
                        //make the Wizard the currently selected character
                        //if selectedCharacter contains WizardFirstName...add WizardLastName 
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
                    " Martial Artist, 5 for a Necromancer, 6 for a Wizard, or 7 to quit: ");
                    characterCreationMenu = scan.nextInt();
                    System.out.println();
                    System.out.println();
                }
                    
            }
            /*When selecting an existing character from here the user is opting to
            select characters that were created during the programs runtime
            or characters they loaded from a save file that they themselves would
            have named.*/
            else if(userMainMenu == 2)
            {
                
                System.out.println("Select an Existing Character");
                System.out.println("--------------------------------");
                System.out.println("Only one character per class can be available"+
                " for selection.\nIf you want to select a different character"+
                " for your desired\nclass then you must create a new character"+
                " for that class or\nload a saved file of a previously created"+
                " character for that\nclass.");
                System.out.println();
                
                //START: display an available Assassin Character if possible
                //--------------------------------------------------------------
                //will retrieve AssassinFirstName.txt
                File Assassin1stFile = new File("src/AssassinFirstName.txt");
                Scanner scanAssassinFirstName = new Scanner(Assassin1stFile);
                
                //see if the AssassinFirstName.txt file has anything in it, returns true or false
                Boolean booleanAssassinFirstNameTxt = scanAssassinFirstName.hasNext();
                
                
                //will retrieve AssassinLastName.txt
                File Assassin2ndFile = new File("src/AssassinLastName.txt");
                Scanner scanAssassinLastName = new Scanner(Assassin2ndFile);
                
                //see if the AssassinLastName.txt file has anything in it, returns true or false
                Boolean booleanAssassinLastNameTxt = scanAssassinLastName.hasNext();
                
                
                /*if the Assassin character's first name txt file is blank then
                tell the user that no character has been created or loaded for the Assassin class*/
                if(booleanAssassinFirstNameTxt == false && booleanAssassinLastNameTxt == false)
                {
                    String NoCharacterAlert1 = "1. No character has been created or loaded for the Assassin class so none can be selected";
                    System.out.println(NoCharacterAlert1);
                }
                
                /*else if there is an Assassin character that has been created or loaded
                then display them.*/
                else if(booleanAssassinFirstNameTxt == true && booleanAssassinLastNameTxt == true)
                {
                    //read the AssassinFirstName.txt file & AssassinLastName.txt File, then display
                    String AssassinFirstNameTxt = scanAssassinFirstName.next();
                    String AssassinLastNameTxt = scanAssassinLastName.next();
                    System.out.println("1. "+AssassinFirstNameTxt+" "+AssassinLastNameTxt+" (Assassin Class)");
                }
                //END: Assassin Character display ends
                //--------------------------------------------------------------
                
                
                //START: display an Available Engineer Character if possible
                //--------------------------------------------------------------
                //will retrieve EngineerFirstName.txt
                File Engineer1stFile = new File("src/EngineerFirstName.txt");
                Scanner scanEngineerFirstName = new Scanner(Engineer1stFile);
                
                //see if the EngineerFirstName.txt file has anything in it, returns true or false
                Boolean booleanEngineerFirstNameTxt = scanEngineerFirstName.hasNext();
                
                
                //will retrieve EngineerLastName.txt
                File Engineer2ndFile = new File("src/EngineerLastName.txt");
                Scanner scanEngineerLastName = new Scanner(Engineer2ndFile);
                
                //see if the EngineerLastName.txt file has anything in it, returns true or false
                Boolean booleanEngineerLastNameTxt = scanEngineerLastName.hasNext();
                
                
                /*if the Engineer character's first name txt file is blank then
                tell the user that no character has been created or loaded for the Engineer class*/
                if(booleanEngineerFirstNameTxt == false && booleanEngineerLastNameTxt == false)
                {
                    String NoCharacterAlert2 = "2. No character has been created or loaded for the Engineer class so none can be selected";
                    System.out.println(NoCharacterAlert2);
                }
                
                /*else if there is an Engineer character that has been created or loaded
                then display them.*/
                else if(booleanEngineerFirstNameTxt == true && booleanEngineerLastNameTxt == true)
                {
                    //read the EngineerFirstName.txt file & EngineerLastName.txt File, then display
                    String EngineerFirstNameTxt = scanEngineerFirstName.next();
                    String EngineerLastNameTxt = scanEngineerLastName.next();
                    System.out.println("2. "+EngineerFirstNameTxt+" "+EngineerLastNameTxt+" (Engineer Class)");
                }
                //END: Engineer Character display ends
                //--------------------------------------------------------------
                
                
                //START: display an Available Healer Character if possible
                //--------------------------------------------------------------
                //will retrieve HealerFirstName.txt
                File Healer1stFile = new File("src/HealerFirstName.txt");
                Scanner scanHealerFirstName = new Scanner(Healer1stFile);
                
                //see if the HealerFirstName.txt file has anything in it, returns true or false
                Boolean booleanHealerFirstNameTxt = scanHealerFirstName.hasNext();
                
                
                //will retrieve HealerLastName.txt
                File Healer2ndFile = new File("src/HealerLastName.txt");
                Scanner scanHealerLastName = new Scanner(Healer2ndFile);
                
                //see if the HealerLastName.txt file has anything in it, returns true or false
                Boolean booleanHealerLastNameTxt = scanHealerLastName.hasNext();
                
                
                /*if the Healer character's first name txt file is blank then
                tell the user that no character has been created or loaded for the Healer class*/
                if(booleanHealerFirstNameTxt == false && booleanHealerLastNameTxt == false)
                {
                    String NoCharacterAlert3 = "3. No character has been created or loaded for the Healer class so none can be selected";
                    System.out.println(NoCharacterAlert3);
                }
                
                /*else if there is a Healer character that has been created or loaded
                then display them.*/
                else if(booleanHealerFirstNameTxt == true && booleanHealerLastNameTxt == true)
                {
                    //read the HealerFirstName.txt file & HealerLastName.txt File, then display
                    String HealerFirstNameTxt = scanHealerFirstName.next();
                    String HealerLastNameTxt = scanHealerLastName.next();
                    System.out.println("3. "+HealerFirstNameTxt+" "+HealerLastNameTxt+" (Healer Class)");
                }
                //END: Healer Character display ends
                //--------------------------------------------------------------
                
                
                //START: display an Available Martial Artist Character if possible
                //--------------------------------------------------------------
                //will retrieve MartialArtistFirstName.txt
                File MartialArtist1stFile = new File("src/MartialArtistFirstName.txt");
                Scanner scanMartialArtistFirstName = new Scanner(MartialArtist1stFile);
                
                //see if the MartialArtistFirstName.txt file has anything in it, returns true or false
                Boolean booleanMartialArtistFirstNameTxt = scanMartialArtistFirstName.hasNext();
                
                
                //will retrieve MartialArtistLastName.txt
                File MartialArtist2ndFile = new File("src/MartialArtistLastName.txt");
                Scanner scanMartialArtistLastName = new Scanner(MartialArtist2ndFile);
                
                //see if the MartialArtistLastName.txt file has anything in it, returns true or false
                Boolean booleanMartialArtistLastNameTxt = scanMartialArtistLastName.hasNext();
                
                
                /*if the Martial Artist character's first name txt file is blank then
                tell the user that no character has been created or loaded for the Healer class*/
                if(booleanMartialArtistFirstNameTxt == false && booleanMartialArtistLastNameTxt == false)
                {
                    String NoCharacterAlert4 = "4. No character has been created or loaded for the Martial Artist class so none can be selected";
                    System.out.println(NoCharacterAlert4);
                }
                
                /*else if there is a Martial Artist character that has been created or loaded
                then display them.*/
                else if(booleanMartialArtistFirstNameTxt == true && booleanMartialArtistLastNameTxt == true)
                {
                    //read the MartialArtistFirstName.txt file & MartialArtistLastName.txt File, then display
                    String MartialArtistFirstNameTxt = scanMartialArtistFirstName.next();
                    String MartialArtistLastNameTxt = scanMartialArtistLastName.next();
                    System.out.println("4. "+MartialArtistFirstNameTxt+" "+MartialArtistLastNameTxt+" (Martial Artist Class)");
                }
                //END: Martial Artist Character display ends
                //--------------------------------------------------------------
                
                
                //START: display an Available Necromancer Character if possible
                //--------------------------------------------------------------
                //will retrieve NecromancerFirstName.txt
                File Necromancer1stFile = new File("src/NecromancerFirstName.txt");
                Scanner scanNecromancerFirstName = new Scanner(Necromancer1stFile);
                
                //see if the NecromancerFirstName.txt file has anything in it, returns true or false
                Boolean booleanNecromancerFirstNameTxt = scanNecromancerFirstName.hasNext();
                
                
                //will retrieve NecromancerLastName.txt
                File Necromancer2ndFile = new File("src/NecromancerLastName.txt");
                Scanner scanNecromancerLastName = new Scanner(Necromancer2ndFile);
                
                //see if the NecromancerLastName.txt file has anything in it, returns true or false
                Boolean booleanNecromancerLastNameTxt = scanNecromancerLastName.hasNext();
                
                
                /*if the Necromancer character's first name txt file is blank then
                tell the user that no character has been created or loaded for the Necromancer class*/
                if(booleanNecromancerFirstNameTxt == false && booleanNecromancerLastNameTxt == false)
                {
                    String NoCharacterAlert5 = "5. No character has been created or loaded for the Necromancer class so none can be selected";
                    System.out.println(NoCharacterAlert5);
                }
                
                /*else if there is a Necromancer character that has been created or loaded
                then display them.*/
                else if(booleanNecromancerFirstNameTxt == true && booleanNecromancerLastNameTxt == true)
                {
                    //read the NecromancerFirstName.txt file & NecromancerLastName.txt File, then display
                    String NecromancerFirstNameTxt = scanNecromancerFirstName.next();
                    String NecromancerLastNameTxt = scanNecromancerLastName.next();
                    System.out.println("5. "+NecromancerFirstNameTxt+" "+NecromancerLastNameTxt+" (Necromancer Class)");
                }
                //END: Necromancer Character display ends
                //--------------------------------------------------------------
                
                
                //START: display an Available Wizard Character if possible
                //--------------------------------------------------------------
                //will retrieve WizardFirstName.txt
                File Wizard1stFile = new File("src/WizardFirstName.txt");
                Scanner scanWizardFirstName = new Scanner(Wizard1stFile);
                
                //see if the WizardFirstName.txt file has anything in it, returns true or false
                Boolean booleanWizardFirstNameTxt = scanWizardFirstName.hasNext();
                
                
                //will retrieve WizardLastName.txt
                File Wizard2ndFile = new File("src/WizardLastName.txt");
                Scanner scanWizardLastName = new Scanner(Wizard2ndFile);
                
                //see if the WizardLastName.txt file has anything in it, returns true or false
                Boolean booleanWizardLastNameTxt = scanWizardLastName.hasNext();
                
                
                /*if the Wizard character's first name txt file is blank then
                tell the user that no character has been created or loaded for the Wizard class*/
                if(booleanWizardFirstNameTxt == false && booleanWizardLastNameTxt == false)
                {
                    String NoCharacterAlert6 = "6. No character has been created or loaded for the Wizard class so none can be selected";
                    System.out.println(NoCharacterAlert6);
                }
                
                /*else if there is a Wizard character that has been created or loaded
                then display them.*/
                else if(booleanWizardFirstNameTxt == true && booleanWizardLastNameTxt == true)
                {
                    //read the WizardFirstName.txt file & WizardLastName.txt File, then display
                    String WizardFirstNameTxt = scanWizardFirstName.next();
                    String WizardLastNameTxt = scanWizardLastName.next();
                    System.out.println("6. "+WizardFirstNameTxt+" "+WizardLastNameTxt+" (Wizard Class)");
                }
                //END: Wizard Character display ends
                //--------------------------------------------------------------
                
                int userCharacterChoice;
                System.out.println();
                System.out.print("Enter the number of the character you want to select: ");
                userCharacterChoice = scan.nextInt();
                System.out.println();
                
                if(userCharacterChoice == 1)
                {
                    
                    if(booleanAssassinFirstNameTxt == false && booleanAssassinFirstNameTxt == false)
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
                    else if(booleanAssassinFirstNameTxt == true && booleanAssassinLastNameTxt == true)
                    {
                        //will retrieve AssassinFirstName.txt
                        File Assassin1stFile2 = new File("src/AssassinFirstName.txt");
                        Scanner scanAssassinFirstName2 = new Scanner(Assassin1stFile2);
                        
                        //will retrieve AssassinLastName.txt
                        File Assassin2ndFile2 = new File("src/AssassinLastName.txt");
                        Scanner scanAssassinLastName2 = new Scanner(Assassin2ndFile2);
                        
                        //read the AssassinFirstName.txt file & AssassinLastName.txt File
                        String AssassinFirstNameTxt = scanAssassinFirstName2.next();
                        String AssassinLastNameTxt = scanAssassinLastName2.next();
                        
                        //make the Assassin the currently selected character
                        /*if both lists are empty...add AssassinFirstNameTxt & 
                        AssassinLastNameTxt then add thisIsAssassin (value 1)*/
                        if(selectedCharacter.isEmpty())
                        {
                            selectedCharacter.add(AssassinFirstNameTxt);
                            selectedCharacter.add(AssassinLastNameTxt);
                            
                            if(selectedCharacterClass.isEmpty())
                            {
                                //determines that this character is of the Assassin Class
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
                            selectedCharacter.add(AssassinFirstNameTxt);
                            selectedCharacterClass.clear();
                            selectedCharacterClass.add(thisIsAssassin);
                        }
                    }
                }
            }
            
            /*I would have made it to where upon a load the user can automatically
            have their loaded character as their selected character, but due to
            a load of other reasons I have notes on I couldn't get this to happen.*/
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
            }
            //character manager menu while loop
            System.out.println("Character Manager");
            System.out.println("-----------------------");
            System.out.print("You have no character selected. Enter 1 to create a"+
                " new character, 2 to select an existing character, \n"+
                "3 to load a character from file, 4 to save a character to file,"+
                " 5 to perform an action, or 6 to exit: ");
            userMainMenu = scan.nextInt();
            System.out.println();
            System.out.println();
        }
    }
}


