package sample;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Scanner;


public class PassengerQueue implements Serializable {

    private Passenger[] queueArray=new Passenger[21]; //this is the array that works as train Queue
    private int first=0;
    private int last=0; //last passenger object
    private int maxStayInQueue=0;
    private int maxLength=0;

    public void add(Passenger passenger){
        queueArray[last]=passenger;
        last++;
    }


    public Passenger[] getQueueArray(){  //use to access queue out of class
        return queueArray;
    }

    public boolean isEmpty(){ //this method is use for check that Train Queue is empty or not
        if (last==0){
            System.out.println("========================================");
            System.out.println(" ");
            System.out.println("======Train is Empty =======");
            System.out.println(" ");
            System.out.println("==========================================");
            return true;
        }else {
            return false;
        }
    }

    public boolean isFull(){ //this method is use for check that train queue is full or not
        if (last==21){
            System.out.println("========================================");
            System.out.println(" ");
            System.out.println("======Train Queue Fully Loaded =======");
            System.out.println(" ");
            System.out.println("==========================================");
            return true;
        }else {
            return false;
        }
    }

    public void display() { //this method is use for display train Queue in a GUI
        Stage stage = new Stage();
        stage.setTitle("Train Queue");
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        FlowPane flowPane = new FlowPane(10, 10);
        flowPane.setPadding(new Insets(10));
        flowPane.setOrientation(Orientation.VERTICAL);
        flowPane.setStyle("-fx-background-color: #ebedf0;");
        borderPane.setCenter(flowPane);

        for (int i = 0; i < 21; i++) {
            if (queueArray[i] != null) {
                Label label=new Label(queueArray[i].getFullName());
                flowPane.getChildren().add(label);
            }
        }

        stage.showAndWait();
    }

    public int delete() { //this method is use for delete passenger

        Scanner scd = new Scanner(System.in);
        System.out.println(" ");
        System.out.println(" ");
        System.out.print("Dear Employee, Please Enter Passenger's name: ");
        String passengerName = scd.nextLine();

        int i;
        for (i = 0; i < last; i++)
            if (queueArray[i].getFullName().equals(passengerName)) //check that user input is available in train queue or not
                break;

        if (i < last) {
            System.out.println("======================================");
            System.out.println(" ");
            System.out.println("====== Successfully Deleted =======");
            System.out.println(" ");
            System.out.println("======================================");
            last = last - 1;
            for (int j = i; j < last; j++) //replace the nobe
                queueArray[j] = queueArray[j + 1];
        }
        return last;

    }

    public int getLast(){ //use to access last value out of the class
        return last;
    }

    public void setLast(int last){
        this.last=last;
    }

    public void write(){ //this method is use for save object array details one by one in a file
        try {
            File savF=new File("cw2FileSL.txt");
            PrintStream writer=new PrintStream(savF);

            int index=0;
            while (index<last){
                if (queueArray[index] !=null){
                    writer.println(queueArray[index].getFullName());
                    writer.println(queueArray[index].getSeat());
                }
                index=index+1;
            }
            System.out.println("=============================================");
            System.out.println(" ");
            System.out.println("====== Successfully Saved in File =======");
            System.out.println(" ");
            System.out.println("=============================================");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("=============================================");
            System.out.println(" ");
            System.out.println("=======Details has not Saved to file========");
            System.out.println(" ");
            System.out.println("==============================================");
        }

    }

    public  void read(){ //this method is use for load object details from file one by one
        try {
            File savF=new File("cw2FileSL.txt");
            Scanner reader=new Scanner(savF);

            String x,y;
            int index=last;

            while (reader.hasNextLine()){
                x=reader.nextLine();
                y=reader.nextLine();

                queueArray[index]=new Passenger();
                queueArray[index].setName(x);
                queueArray[index].setSeat(y);

                index=index+1;
            }
            System.out.println("==================================");
            System.out.println(" ");
            System.out.println("====== Successfully Loaded =======");
            System.out.println("");
            System.out.println("==================================");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("============================================");
            System.out.println(" ");
            System.out.println("======= File has not loaded to Queue======");
            System.out.println(" ");
            System.out.println("============================================");
        }

    }

}

