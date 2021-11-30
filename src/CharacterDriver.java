
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

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
        seal their opponents in another dimension for quite a while*/
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
                        " (piloted or autonomous) which they can repair and upgrade.");//not finished w/ descriptions
                        System.out.println();
                        System.out.print("When ready, press enter to continue");
                        try{System.in.read();}
                        catch(Exception e){}
                        System.out.println();
                        System.out.println();
                       
                    }
                    
                    else if(characterCreationMenu == 1)
                    {
                        getAccuracy assassinAcc = new getAccuracy();
                        getAttack assassinAtt = new getAttack();
                        getDamage assassinDmg = new getDamage();
                        getPhyDef assassinPhyDef = new getPhyDef();
                        getMagDef assassinMagDef = new getMagDef();
                    
                        Assassin Assassin = new Assassin(assassinAcc, assassinAtt,
                            assassinDmg, assassinPhyDef, assassinMagDef);
                    
                        File rangeText = new File("src/range.txt");
                        Scanner scan2 = new Scanner(rangeText);
                        int rangeInt1 = scan2.nextInt();//1
                        int rangeInt2 = scan2.nextInt();//10
                        Random generator = new Random();
                    
                    
                        int randomAccuracyStat;
                        int randomAttackStat;
                        int randomDamageStat;
                        int randomPhyDefStat;
                        int randomMagDefStat;
                    
                        int randomNum1;
                        int randomNum2;
                        int randomNum3;
                        int randomNum4;
                        int randomNum5;
        
                        randomNum1 = generator.nextInt(rangeInt2)+rangeInt1;/*random
                        # between 1-10*/
                        randomNum2 = generator.nextInt(rangeInt2)+rangeInt1;/*random
                        # between 1-10*/
                        randomNum3 = generator.nextInt(rangeInt2)+rangeInt1;/*random
                        # between 1-10*/
                        randomNum4 = generator.nextInt(rangeInt2)+rangeInt1;/*random
                        # between 1-10*/
                        randomNum5 = generator.nextInt(rangeInt2)+rangeInt1;/*random
                        # between 1-10*/
              
                        System.out.println("Assassin Class Build");
                        System.out.println("-----------------------");
                        System.out.println("Character stats: Accuracy, Attack, Damage, Physical Defense, and Magical Defense");
                        System.out.println();
                        System.out.println("Random numbers to use for your stats: A."+randomNum1+"  B."+randomNum2+"  C."+randomNum3+"  D."+randomNum4+"  E."+randomNum5);
                        System.out.println();
                        System.out.println("Select a letter from above to add its numeric value to the stat you want it added to.");
                        System.out.println();
                        System.out.println("Example: Enter your Accuracy stat: C (this would make your Accuracy Stat equal to "+randomNum3+")");
                        System.out.println();
                        System.out.print("Enter your Accuracy stat: ");
                        String accuracyStatChoice;
                        accuracyStatChoice = scan.next();
                        System.out.println();
                        System.out.println();
                        if(accuracyStatChoice.equals("a") || accuracyStatChoice.equals("A"))//have to do this for accuracy stat 4 more times (randnum2,3,4, and 5)
                        {
                            randomAccuracyStat = randomNum1;
                            try
                            {
                                FileWriter writeStats = new FileWriter("src/AssassinStats.txt");
                                writeStats.write(String.valueOf(randomAccuracyStat));//when writing to file for other stats, do a new line like in file/exceptions before writing
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                        }
                        else if(accuracyStatChoice.equals("b") || accuracyStatChoice.equals("B"))
                        {
                            randomAccuracyStat = randomNum2;
                            try
                            {
                                FileWriter writeStats = new FileWriter("src/AssassinStats.txt");
                                writeStats.write(String.valueOf(randomAccuracyStat));
                                writeStats.close();
                            }
                            catch(IOException exception)
                            {
                                exception.printStackTrace();
                            }
                        }
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


