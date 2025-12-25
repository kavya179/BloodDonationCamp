import java.util.*;

class BloodDonationCamp{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        Main ob1=new Main();
        find_search  ob2=new find_search ();
        boolean a=true;

        // The  Menu loop to keep the program running
        while(a==true){
            System.out.println("\n--Welcome to the Blood Donation Camp!--");
            System.out.println("1. Register as a Donor");
            System.out.println("2. View All Donors");
            System.out.println("3. Search Donors detail by thier Blood Group");
            System.out.println("4. Find donor by bloodGroup");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");
            int choice=sc.nextInt();
            sc.nextLine();

            // The Process user input
            switch(choice)
            {
                case 1:
                    ob1.registerDonor();
                    break;

                case 2:
                    ob1.viewDonor();
                    break;

                case 3:
                    ob2.searchDonor();
                    break;

                case 4:
                    ob2.finddonorDetails();
                    break;
                case 5:
                {
                    System.out.println("\nThank you for using the Blood Donation Camp system. Goodbye!");
                    return;
                }
                default:
                    System.out.println("Invalid choice, please try again.");

            }
        }
    }
}
class Main{

    // Simple data storage for donor names,blood groups,donor age,donor weight,donor num,donation date and donor gender.
    static String[] donorNames = new String[10];
    static String[] bloodGroups = new String[10];
    int age[]= new int[10];
    double[] weight= new double[10];
    static long[] num= new long[10];
    static String[] date= new String[10];
    static String[] gender=new String[10];
    static int[] Donor_Id=new int[10];
    static int Id=135;

    static int donorCount = 0; // donorCount track of how many donors are registered.
    int month;
    int day;
    int year=2025;

    // The Method to register a new donor
    void registerDonor()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("---For BloodDonation You Have To Follow Below Instructions!---");
        System.out.println();
        System.out.println("> You Should Be At Least 18 Years Old And No More Than 65 Years old.");
        System.out.println("> You Should Weigh At Least 45 kg");
        System.out.println("> You should not donate if you have HIV,Hepatitis B etc...");

        if (donorCount >= donorNames.length) {
            System.out.println("Sorry, The donation list is full.");
            return;
        }


        System.out.println("\n--- Register as a Donor ---");
        System.out.print("\n\nEnter your name: ");
        String name = sc.nextLine();
        donorNames[donorCount] = name;
        boolean u=true;
        while (u)
        {
            for (int i = 0; i < donorNames[donorCount].length(); i++)
            {
                char ch = donorNames[donorCount].charAt(i);
                // Check if the character is not a letter (A-Z or a-z)
                if (((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')))
                {
                    u = false; // Name is valid, exit loop
                }
                else
                {
                    System.out.println("Invalid name. Please enter a name with only letters (A-Z).");
                    donorNames[donorCount] = sc.nextLine(); // Prompt the user again
                }
            }
        }
        boolean x=true;
        while(x){
            System.out.print("\nEnter your blood group (A+, O+, B+, AB+, A-, O-, B-, AB-): ");
            String bloodGroup1 = sc.nextLine().toUpperCase();
            bloodGroups[donorCount] = bloodGroup1;
            if(bloodGroups[donorCount].equalsIgnoreCase("A+") || bloodGroups[donorCount].equalsIgnoreCase("O+")||bloodGroups[donorCount].equalsIgnoreCase("B+")|| bloodGroups[donorCount].equalsIgnoreCase("AB+")||bloodGroups[donorCount].equalsIgnoreCase("A-")||bloodGroups[donorCount].equalsIgnoreCase("O-")||bloodGroups[donorCount].equalsIgnoreCase("B-")||bloodGroups[donorCount].equalsIgnoreCase("AB-")){
                x=false;
                break;
            }
            else{
                System.out.println("Invalid Blood_Group");
            }
        }
        int choice3;
        while(true)
        {
            System.out.println("\nEnter your gender\n1-Male:\n2-Female\n3-Other");
            choice3=sc.nextInt();
            if(choice3<4 && choice3>0)
                break;
            else
            {
                System.out.println("\nInvalid input");
                System.out.println();
            }
        }
        if(choice3==1)
            gender[donorCount]="male";
        if(choice3==2)
            gender[donorCount]="female";
        if(choice3==3)
            gender[donorCount]="other";

        int age1=0;
        boolean b=true;
        while(b)
        {
            System.out.println("\nEnter your age:");
            age1=sc.nextInt();
            if(age1>0){
                b=false;
                break;
            }
            else
            {
                System.out.println("\nEnvalid Age !! \nPlease Enter Valid Age.");
                b=true;
            }
        }
        age[donorCount] = age1;


        double weight1=0.0;
        boolean c=true;
        while(c)
        {
            System.out.println("\nEnter The Weight Of The Donor:");
            weight1=sc.nextDouble();
            if(weight1>0){
                b=false;
                break;
            }
            else
            {
                System.out.println("\nEnvalid Weight !! \nPlease Enter Valid Weight.");
                b=true;
            }
        }

        weight[donorCount] = weight1;

        long number;

        System.out.println("Enter Donor's mobile number (10 digits):");
        number = sc.nextLong();
        String s=number+"";
        boolean d=true;
        while(d){
            s=number+"";
            if(s.length()!=10){
                System.out.println("Enter 10 digit number");
                number=sc.nextLong();
            }
            else{
                d=false;
                num[donorCount]=number;
            }

        }


        System.out.println("Enter the date on which you want to donate blood (dd/mm/yyyy):");
        Main ob3=new Main();
        date[donorCount]=ob3.getValidDate() ;

        if(age1>=18 && weight1>=40)
        {
            System.out.println("You can Donate blood.");
            System.out.println();
            System.out.println("Your registration is done.");
            System.out.println();
            this.Donor_Id[donorCount]=Id;
            System.out.println("Your Donor_Id is:"+Donor_Id[donorCount]);
            Id++;
            donorCount++;	// Increase donor count
        }
        if(age1<18 || weight1<40){
            if(age1<18 && weight1>=40)
                System.out.println("Your age is not setisfaid for donating blood.");
            if(age1>=18 && weight1<40)
                System.out.println("Your body weight is not setisfaid for donating blood.");
            System.out.println("Sorry,You can not Donate blood at this age.");

        }

    }

    String getValidDate()
    {
        Scanner sc = new Scanner(System.in);
        boolean w = false;
        do {
            System.out.print("Enter Month (1-12): ");
            month = sc.nextInt();
            System.out.print("Enter Day: ");
            day = sc.nextInt();


            if (month >= 1 && month <= 12)
            {
                int maxDays = (month == 2) ? 28 : (month == 4 || month == 6 || month == 9 || month == 11) ? 30 : 31;
                if (day >= 1 && day <= maxDays)
                {
                    w = true;
                }
            }

            if (!w)
            {
                System.out.println("Invalid date! Please enter a correct date.");
            }

        }	 while (!w);

        return day + "/" + month + "/" + year;
    }

    // The Method to display all registered donors
    void viewDonor(){
        Scanner sc=new Scanner(System.in);
        if(donorCount==0){
            System.out.println("No Donor register yet.\n");
            return;
        }
        System.out.println("-----List of all Donors------");
        for(int i=0;i<donorCount;i++){
            System.out.println("\nName of the Donor is: "+donorNames[i]);
            System.out.println();
            System.out.println("Blood Group of the Donor is: "+bloodGroups[i]);
            System.out.println();
            System.out.println("Gender of the Donor is:"+gender[i]);
            System.out.println();
            System.out.println("Donors number is: "+num[i]);
            System.out.println();
            System.out.println("Date of donating:"+date[i]);
            System.out.println();
        }
        System.out.println();
    }


}


class find_search extends Main{


    void searchDonor() 						//The Method to searchDonor by thier Donor_Id,By Name,Blood_Group,By Date
    {
        Scanner sc=new Scanner(System.in);
        if(donorCount>0)
        {
            int choice4;
            while(true){
                System.out.println("Enter the choice from which you want to search Donor details.\n1-By Donor_Id.\n2-By Blood_Group\n3-By Date.");
                choice4=sc.nextInt();
                if(choice4<5 && choice4>0)
                    break;
                else
                    System.out.println("Envalid input.");
            }
            if(choice4==1)
            {
                System.out.println("Enter the Donor_Id Which you want to Search.");
                int Donor_Id2=sc.nextInt();
                for(int i=0;i<donorCount;i++)
                {
                    System.out.println("\n-----Donors with Donor_Id :" + Donor_Id2 + " -----");
                    if(Donor_Id[i]==(Donor_Id2))
                    {
                        System.out.println();
                        System.out.println("Name of the Donor is: "+donorNames[i]);
                        System.out.println("Blood Group of the Donor is: "+bloodGroups[i]);
                        System.out.println("Gender of the Donor is:"+gender[i]);
                        System.out.println("Donors number is: "+num[i]);
                        System.out.println("Date of donating:"+date[i]);
                    }
                    else{
                        System.out.println("No donors found with the Donor_Id: " + Donor_Id2 + ".\n");
                    }
                }

                if(donorCount<=0)
                {
                    System.out.println("NO Donor register Yet With The Donor_Id:"+ Donor_Id2);
                }


            }

            if(choice4==2)
            {

                System.out.println("Enter the blood group to search (A+, O+, B+, AB+, A-, O-, B-, AB-): ");
                sc.nextLine();
                String bloodGroup=sc.nextLine();
                for(int i=0;i<donorCount;i++)
                {
                    System.out.println("\n-----Donors with Blood Group :" + bloodGroup + " -----");
                    if(bloodGroups[i].equalsIgnoreCase(bloodGroup))
                    {

                        System.out.println();
                        System.out.println("Name of the Donor is: "+donorNames[i]);
                        System.out.println("Blood Group of the Donor is: "+bloodGroups[i]);
                        System.out.println("Gender of the Donor is:"+gender[i]);
                        System.out.println("Donors number is: "+num[i]);
                        System.out.println("Date of donating:"+date[i]);
                        System.out.println("Your Donor_Id is:"+Donor_Id[i]);
                    }
                    else
                    {
                        System.out.println("No donors found with the Name: " + bloodGroup + ".\n");
                    }
                }
                if(donorCount<=0)
                {
                    System.out.println("NO Donor register Yet With The Blood_Group:"+bloodGroup);
                }

            }
            if(choice4==3){
                System.out.println("Enter the date on wich you donoted the blood.");
                sc.nextLine();
                String date2=sc.nextLine();
                for(int i=0;i<donorCount;i++)
                {
                    System.out.println("\n-----Donors with Date :" + date2 + " -----");
                    if(date[i].equalsIgnoreCase(date2)){

                        System.out.println();
                        System.out.println("Name of the Donor is: "+donorNames[i]);
                        System.out.println("Blood Group of the Donor is: "+bloodGroups[i]);
                        System.out.println("Gender of the Donor is:"+gender[i]);
                        System.out.println("Donors number is: "+num[i]);
                        System.out.println("Date of donating:"+date[i]);
                        System.out.println("Your Donor_Id is:"+Donor_Id[i]);
                    }
                    else{
                        System.out.println("No donors found with the Donation Date: " +date2 + ".\n");
                    }
                }
                if(donorCount<=0){
                    System.out.println("NO Donor register Yet.");
                }
            }
        }
        else
        {
            System.out.println("There Is No Donor Donated Blood , Sorry!");
        }
    }





    //The method to give user to search thier needed blood
    void finddonorDetails()
    {
        if(donorCount>0){
            Scanner sc=new Scanner(System.in);
            boolean x=true;
            String needblood="";
            while(x){
                System.out.print("\nEnter your blood group (A+, O+, B+, AB+, A-, O-, B-, AB-): ");
                needblood = sc.nextLine().toUpperCase();
                if(needblood.equalsIgnoreCase("A+") || needblood.equalsIgnoreCase("O+")||needblood.equalsIgnoreCase("B+")|| needblood.equalsIgnoreCase("AB+")||needblood.equalsIgnoreCase("A-")||needblood.equalsIgnoreCase("O-")||needblood.equalsIgnoreCase("B-")||needblood.equalsIgnoreCase("AB-")){
                    x=false;
                    break;
                }
                else{
                    System.out.println("Invalid Blood_Group");
                }
            }
            System.out.println("For what purpose you want that blood?");
            System.out.println("1-Medical emergency");
            System.out.println("2-Hospital Storage");
            System.out.println("3-other");
            int choice2=sc.nextInt();
            switch(choice2){

                case 1:
                    break;
                case 2:
                    break;
                case 3:
                {
                    System.out.println("Enter your purpose:");
                    int purpose=sc.nextInt();
                    break;
                }
                default :
                    System.out.println("Invalid input");
            }
            for(int i=0;i<donorCount;i++)
            {
                if(needblood.equalsIgnoreCase(bloodGroups[i]))
                {
                    System.out.println("You can get the blood.");
                    System.out.println("Name of the Donor is: "+donorNames[i]);
                    System.out.println("Blood Group of the Donor is: "+gender[i]);
                    System.out.println("Donors number is: "+num[i]);
                }
                else
                    System.out.println("Sorry,This blood is not avalable.");

            }
        }
        else
        {
            System.out.println("There Is No Donor Donated Blood , Sorry!");
        }
    }

}