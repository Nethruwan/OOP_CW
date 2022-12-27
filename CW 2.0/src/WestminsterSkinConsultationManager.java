import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    Scanner obj = new Scanner(System.in);

    ArrayList <Doctor> doctorList = new ArrayList<>();
    ArrayList <String> doctorTempList = new ArrayList<>();

    public void addDoctor (){


        System.out.println("executing addDoctor");

        if (doctorList.size() != 10){

            Doctor person = new Doctor();

            System.out.print("Enter Doctor Name: ");
            person.setName(obj.nextLine());

            System.out.print("Enter Doctor Surname: ");
            person.setSurname(obj.nextLine());

            System.out.print("Enter Doctor Date of birth: ");
            person.setDateOfBirth(LocalDate.parse(obj.nextLine()));

            System.out.print("Enter Doctor Mobile Number: ");
            person.setMobileNumber(obj.nextLine());

            System.out.print("Enter Doctor Licence Number: ");
            person.setLicenceNumber(obj.nextLine());

            System.out.print("Enter Doctor Specialisation: ");
            person.setSpecialisation(obj.nextLine());

            doctorList.add(person);
        }
    }

    public void deleteDoctor(){
        String ID;
        System.out.println("Enter Doctor Licence Number");
        ID = obj.nextLine();
        for (int i = 0 ; i < doctorList.size() ; i++ ){
            Doctor doctor = doctorList.get(i);
            if (doctor.getLicenceNumber().equals(ID)){
                System.out.println(doctor.getLicenceNumber());
                System.out.println(doctor.getName());
                doctorList.remove(i);
                break;
            }
        }

    }

    public void  printDoctors(){
        doctorList.sort(new Comparator<Doctor>() {
            @Override
            public int compare(Doctor o1, Doctor o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });


        for (int i = 0 ; i < doctorList.size() ; i++){
            Doctor doctor = doctorList.get(i);
            System.out.println("Name: "+doctor.getName());
            System.out.println("Surname: "+doctor.getSurname());
            System.out.println("Date Of Birth: "+doctor.getDateOfBirth());
            System.out.println("Mobile Number: "+doctor.getMobileNumber());
            System.out.println("licence Number: "+doctor.getLicenceNumber());
            System.out.println("Specialisation: "+doctor.getSpecialisation());
            System.out.println("******\n");
        }
    }

    public  void  saveDocument() {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:/IIT/L5/OOP/CW/output.txt"));
            for (int i = 0 ; i <doctorList.size(); i++){
                Doctor doctor = doctorList.get(i);
                bw.write(doctor.getName()+"\n");
                bw.write(doctor.getSurname()+"\n");
                bw.write(doctor.getDateOfBirth().toString()+"\n");
                bw.write(doctor.getMobileNumber()+"\n");
                bw.write(doctor.getLicenceNumber()+"\n");
                bw.write(doctor.getSpecialisation()+"\n");
            }
            bw.close();
            System.out.println("successfully saved to output.txt file");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

//    public void loadDocumentData () {
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("D:/IIT/L5/OOP/CW/output.txt"));
//            String lines;
//            int count = 0;
//            while ((lines = br.readLine()) != null) {
//                for (int i = 0 ; i < 6 ; i++) {
//                    Doctor doctor = doctorList.get(count);
//                    switch (i){
//                        case 0 :   doctor.setName(lines);
//                            break;
//                        case 1 :   doctor.setSurname(lines);
//                            break;
//                        case 2 :   doctor.setDateOfBirth(LocalDate.parse(lines));
//                            break;
//                        case 3 :   doctor.setMobileNumber(lines);
//                            break;
//                        case 4 :   doctor.setLicenceNumber(lines);
//                            break;
//                        case 5 :   doctor.setSpecialisation(lines);
//                            break;
//                        default:   System.out.println("Error:::");
//                            break;
//                    }
//                    doctorList.add(doctor);
//                    System.out.println(lines);
//                }
//                count += 1 ;
//                System.out.println(lines);
//            }
//            br.close();
//            System.out.println(" Load Data from output.txt file successfully");
//        } catch (Exception ex) {
//            System.out.println("error occurred");
//        }
//    }


    public void loadDocumentData () {
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:/IIT/L5/OOP/CW/output.txt"));
            String lines;
            while ((lines = br.readLine()) != null) {
                doctorTempList.add(lines);

//                whileCount += 1;
//                switch (count){
//                    case 0 :   person.setName(lines);
//                        break;
//                    case 1 :   person.setSurname(lines);
//                        break;
//                    case 2 :   person.setDateOfBirth(LocalDate.parse(lines));
//                        break;
//                    case 3 :   person.setMobileNumber(lines);
//                        break;
//                    case 4 :   person.setLicenceNumber(lines);
//                        break;
//                    case 5 :   person.setSpecialisation(lines);
//                        break;
//                }
//                System.out.println(lines);
//                count +=1 ;
//                if (count == 6){
//                    count = 0 ;
//                    System.out.println(" ");
//                    doctorList.add(person);
//                }
            }

//            for (int i = 0; i < doctorTempList.size(); i++){
//                System.out.println(doctorTempList.get(i));
//            }

            for (int i=0 ; i < doctorTempList.size(); i++ ){
                doctorList.add(new Doctor(doctorTempList.get(0),doctorTempList.get(1),LocalDate.parse(doctorTempList.get(2)),
                        doctorTempList.get(3),doctorTempList.get(4),doctorTempList.get(5)));
                doctorTempList.subList(0,6).clear();

            }

//            for (int j = 0; j < doctorList.size(); j++){
//                Doctor doctor = doctorList.get(j);
//                System.out.println("Name: "+doctor.getName());
//                System.out.println("Surname: "+doctor.getSurname());
//                System.out.println("Date Of Birth: "+doctor.getDateOfBirth());
//                System.out.println("Mobile Number: "+doctor.getMobileNumber());
//                System.out.println("licence Number: "+doctor.getLicenceNumber());
//                System.out.println("Specialisation: "+doctor.getSpecialisation());
//                System.out.println("******\n");
//            }
            br.close();
            System.out.println(" Load Data from output.txt file successfully");
        } catch (Exception e) {
            System.out.println("error occurred");
        }
    }

    public void consoleMenuList (){
        System.out.println(" ");
        System.out.println("Enter number 1 - for add doctors");
        System.out.println("Enter number 2 - for delete doctors");
        System.out.println("Enter number 3 - for print list of doctors");
        System.out.println("Enter number 4 - for save file");
        System.out.println("Enter number 5 - for load file");
        System.out.println("Enter number 6 - for quit");
        System.out.println(" ");
    }

    public void consoleMenuSelection (){
        String number;

        boolean run = true;

        while (run) {
            consoleMenuList();
            System.out.print("Number: ");
            number = obj.nextLine();
            switch (number) {
                case "1":
                    addDoctor();
                    break;
                case "2":
                    deleteDoctor();
                    break;
                case "3":
                    printDoctors();
                    break;
                case "4":
                    saveDocument();
                    break;
                case "5":
                    loadDocumentData ();
                    break;
                case "6" :  System.out.println("quited");
                    run = false;
                    break;
                default:
                    System.out.println("Error invalid input. Please Enter Valid Input ");
            }
        }
    }


    public static void main(String[] args) {

        WestminsterSkinConsultationManager doc = new WestminsterSkinConsultationManager();
        doc.consoleMenuSelection();

    }
}
