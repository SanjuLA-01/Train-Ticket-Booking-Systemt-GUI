package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class TrainStation extends Application {
    int count=0;// this is use to count waiting room objects
    private Passenger[] waitingRoom= new Passenger[42]; //this is the waiting room
    private PassengerQueue trainQueue=new PassengerQueue(); //use to call passengerQueue class
    int trainCount=0;//this is use to count train objects
    private Passenger[] train=new Passenger[42]; //this is the train


    @Override
    public void start(Stage primaryStage) throws Exception {
        HashMap<String,String> nameSeatMap=new HashMap<String, String>(); //loaded data save in here (Badulla to Colombo)
        HashMap<String,String> nameSeatMap2=new HashMap<String, String>(); //loaded data save in here  (Colombo to Badulla)
        System.out.println(" ==== WELCOME TO DENUWARA MANIKE TRAIN BOOKING SYSTEM ==== (office Edition)");

        //reading both trips files and saving data in hashmaps
        try {
            Scanner sc = new Scanner(new File("C:\\Users\\SANJULA\\IdeaProjects\\CW1newFinal\\slFile.txt")).useDelimiter("\\s+");
            while(sc.hasNextLine()){
                String fName = sc.nextLine();
                String seat  = sc.nextLine();
                nameSeatMap.put(fName,seat);
            }

        } catch (FileNotFoundException ex) {
            System.err.println("====== We can not find the File ======");
        }finally {
            System.out.println("===== Successfully Loaded (Badulla to Colombo Data)=====");
        }

        try {
            Scanner sc = new Scanner(new File("C:\\Users\\SANJULA\\IdeaProjects\\CW1newFinal\\slFile1.txt")).useDelimiter("\\s+");
            while(sc.hasNextLine()){
                String fName = sc.nextLine();
                String seat  = sc.nextLine();
                nameSeatMap2.put(fName,seat);
            }

        } catch (FileNotFoundException ex) {
            System.err.println("====== We can not find the File ======");
        }finally {
            System.out.println("===== Successfully Loaded (Badulla to Colombo Data)=====");
        }


        trip: //employee has to choose which trip he needs to work with
        {
            while (true){
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("Enter (1)----> (badulla to colombo)");
                System.out.println("Enter (2)----> (colombo to badulla)");
                Scanner sc1=new Scanner(System.in);
                System.out.print("Dear Employee which trip list do you want to add to the waiting room: ");
                String tripOption=sc1.nextLine();
                switch (tripOption){
                    case "1":
                        Stage stage = new Stage();
                        BorderPane borderPane = new BorderPane();
                        Scene scene = new Scene(borderPane,550,850);
                        stage.setScene(scene);
                        FlowPane flowPane = new FlowPane(10, 10);
                        flowPane.setOrientation(Orientation.VERTICAL);
                        flowPane.setStyle("-fx-background-color: #6df7a7;");
                        Label label = new Label("Click on names to add to Waiting Room");
                        flowPane.getChildren().add(label);

                        nameSeatMap.forEach((key, value) -> {
                            Button seatButton = new Button();
                            seatButton.setText(key);
                            seatButton.setStyle("-fx-background-color: \n" +
                                    "        #3c7fb1,\n" +
                                    "        linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                                    "    -fx-padding: 3 30 3 30;\n" +
                                    "    -fx-font-size: 14px;");
                            flowPane.getChildren().add(seatButton);

                            seatButton.setOnAction(event -> {
                                seatButton.setDisable(true);
                                seatButton.setStyle("-fx-background-color: \n" +
                                        "        #fc3003,\n" +
                                        "        linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                                        "    -fx-padding: 3 30 3 30;\n" +
                                        "    -fx-font-size: 14px;");
                                String fullName =seatButton.getText();
                                String seat =nameSeatMap.get(fullName);
                                waitingRoom[count]=new Passenger(); //create Objects
                                waitingRoom[count].setName(fullName);
                                waitingRoom[count].setSeat(seat);
                                count++;
                            });

                        });
                        borderPane.setCenter(flowPane);
                        stage.showAndWait();
                        break trip;

                    case "2":
                        Stage stage1 = new Stage();
                        BorderPane borderPane1 = new BorderPane();
                        Scene scene1 = new Scene(borderPane1,550,850);
                        stage1.setScene(scene1);
                        FlowPane flowPane1 = new FlowPane(10, 10);
                        flowPane1.setOrientation(Orientation.VERTICAL);
                        flowPane1.setStyle("-fx-background-color: #6df7a7;");
                        Label label1 = new Label("Click on names to add to Waiting Room");
                        flowPane1.getChildren().add(label1);

                        nameSeatMap2.forEach((key, value) -> {
                            Button seatButton = new Button();
                            seatButton.setText(key);
                            seatButton.setStyle("-fx-background-color: \n" +
                                    "        #3c7fb1,\n" +
                                    "        linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                                    "    -fx-padding: 3 30 3 30;\n" +
                                    "    -fx-font-size: 14px;");
                            flowPane1.getChildren().add(seatButton);

                            seatButton.setOnAction(event -> {
                                seatButton.setDisable(true);
                                seatButton.setStyle("-fx-background-color: \n" +
                                        "        #fc3003,\n" +
                                        "        linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                                        "    -fx-padding: 3 30 3 30;\n" +
                                        "    -fx-font-size: 14px;");
                                String fullName =seatButton.getText();
                                String seat =nameSeatMap2.get(fullName);
                                waitingRoom[count]=new Passenger(); //create objects
                                waitingRoom[count].setName(fullName);
                                waitingRoom[count].setSeat(seat);
                                count++;
                            });

                        });
                        borderPane1.setCenter(flowPane1);
                        stage1.showAndWait();
                        break trip;

                    default:
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println(" Invalid Input Re Enter");
                        break;
                }
            }
        }

        console:
        {
            while (true) {
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("Enter [A/a]----> to customer to trainQueue ");
                System.out.println("Enter [V/v]----> to view the trainQueue");
                System.out.println("Enter [D/d]----> to delete passenger from the trainQueue ");
                System.out.println("Enter [S/s]----> to store data into a plain text file ");
                System.out.println("Enter [L/l]----> to lad data back from the file into the trainQueue ");
                System.out.println("Enter [R/r]----> to run the simulation and produce report");
                System.out.println("Enter [Q/q]----> to quit");
                System.out.println(" ");
                System.out.println(" ");
                Scanner sc = new Scanner(System.in);
                System.out.print("Dear Employee What you want to do: ");
                String userOption = sc.nextLine();
                switch (userOption) {
                    case "A":
                    case "a":
                        addPassengersToQueue();
                        break;

                    case "V":
                    case "v":
                        viewTrainQueue();
                        break;

                    case "D":
                    case "d":
                        deletePassengerFromQueue();
                        break;

                    case "S":
                    case "s":
                        saveTrainQueue();
                        break;

                    case "L":
                    case "l":
                        loadTrainQueue();
                        break;

                    case "R":
                    case "r":
                        reportForTrainQueue();
                        break;

                    case "Q":
                    case "q":
                        System.out.println("GOOD BYE");
                        break console;

                    default:
                        System.out.println("Invalid! Re Enter");
                }
            }
        }

    }

    private void viewTrainQueue() {
        Stage stage = new Stage();  //GUI for board to train
        stage.setTitle("Train Queue");
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        FlowPane flowPane = new FlowPane(10, 10);
        flowPane.setPadding(new Insets(10));
        flowPane.setOrientation(Orientation.VERTICAL);
        flowPane.setStyle("-fx-background-color: #6df7a7;");
        borderPane.setCenter(flowPane);

        //checking passengers seat numbers
        for(int i=1;i<43;i++){
            Button btn=new Button(String.valueOf(i));
            for (int k=0;k<trainQueue.getLast();k++){
                if(String.valueOf(i).equals(trainQueue.getQueueArray()[k].getSeat())){
                    btn.setText(String.valueOf(i)+" "+trainQueue.getQueueArray()[k].getFullName());
                }else {
                    btn.setText(String.valueOf(i)+" "+"Empty");
                }
            }

            flowPane.getChildren().addAll(btn);
        }

        stage.showAndWait();
    }

    private void reportForTrainQueue() {

        trainQueue.isEmpty();

        for(int k=0;k<trainQueue.getLast();k++){  //board passengers to train
            train[trainCount++]=trainQueue.getQueueArray()[k];
        }

        int total=0;
        for(int i=0;i<trainQueue.getLast();i++){  //calculate waiting time for every passenger and adding one by one
            Random random2=new Random();
            int dice3=random2.nextInt(18)+1;
            total=total+dice3;
            train[i].setSecondsInQueue(total);
        }

        trainQueue.setLast(0);

        int minimumTime= train[0].getSeconds();
        int maximumTime=train[trainCount-1].getSeconds();
        int lengthOfTrain=trainCount;
        int averageTime=total/lengthOfTrain;

        //saving Report Details In a file
        try {
            File savF=new File("cw2FileReport.txt");
            PrintStream writer=new PrintStream(savF);

            int index=0;
            while (index<trainCount){
                if (train[index] !=null){
                    writer.println(index+1);
                    writer.println(train[index].getFullName());
                    writer.println(train[index].getSeat());
                    writer.println(train[index].getSeconds());
                    writer.println("================================");
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


        Stage stage = new Stage();        // GUI for report
        stage.setTitle("REPORT");
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        FlowPane flowPane = new FlowPane(10, 10);
        flowPane.setPadding(new Insets(10));
        flowPane.setOrientation(Orientation.VERTICAL);
        flowPane.setStyle("-fx-background-color: #6df7a7;");
        borderPane.setCenter(flowPane);

        for (int i = 0; i < trainCount; i++) {
            if (train[i] != null) {
                Button button=new Button("Passenger Name: "+train[i].getFullName()+"     " + "Seat Number: " + train[i].getSeat()+"    " +"Waiting Time in Train Queue: "+train[i].getSeconds());
                flowPane.getChildren().add(button);
            }
        }

        Label label1=new Label("Length of The Train Queue: "+lengthOfTrain);
        Label label2=new Label("Minimum Waiting Time of The Train Queue: "+minimumTime);
        Label label3=new Label("Maximum Waiting Time of The Train Queue: "+maximumTime);
        Label label4=new Label("Average Waiting Time of The Train Queue: "+averageTime);
        flowPane.getChildren().addAll(label1,label2,label3,label4);

        stage.showAndWait();

    }

    private void loadTrainQueue() {
        trainQueue.read();
    }

    private void saveTrainQueue() throws IOException {
        trainQueue.write();
    }

    private void deletePassengerFromQueue() {
        System.out.println("=====================================================================================");
        System.out.println(" ");
        System.out.println("=====If there is no any message with 'Successfully Deleted' in below =====");
        System.out.println("====Tey again with correct nam there is no Passenger in Train Queue with that Name====");
        System.out.println(" ");
        System.out.println("=====================================================================================");

        trainQueue.delete(); //call to delete method in passengerQueue

    }

    private void addPassengersToQueue() {
        trainQueue.isFull(); //check train queue is full or not
        if (count==0){ //check waiting room empty or not
            System.out.println("=========================================== ");
            System.out.println(" ");
            System.out.println("========= waiting Room is Empty ========");
            System.out.println(" ");
            System.out.println("============================================ ");
        }else {
            Random random = new Random();
            int dice1 = random.nextInt(6) + 1;

            int remain = 21 - trainQueue.getLast();

            if (dice1 >= remain) { //check that remain nobes in train queue are lower than or greater than to random generate number
                dice1 = remain;

                for (int i = 0; i < dice1; i++) {
                    trainQueue.add(waitingRoom[i]);
                }

                for (int j = 0; j < dice1; j++) {
                    for (int k = 0; k < count; k++) {
                        waitingRoom[k] = waitingRoom[k + 1];
                    }
                }
                count = count - dice1;

            } else {

                if (dice1 > count) { //check that remain object count is greater than or lower than to random generate number
                    dice1 = count;
                    for (int i = 0; i < dice1; i++) {
                        trainQueue.add(waitingRoom[i]);
                    }

                    for (int j = 0; j < dice1; j++) {
                        for (int k = 0; k < count; k++) {
                            waitingRoom[k] = waitingRoom[k + 1];
                        }
                    }
                    count = count - dice1;
                } else {
                    for (int i = 0; i < dice1; i++) {
                        trainQueue.add(waitingRoom[i]);
                    }

                    for (int j = 0; j < dice1; j++) {
                        for (int k = 0; k < count; k++) {
                            waitingRoom[k] = waitingRoom[k + 1];
                        }
                    }
                    count = count - dice1;
                }

            }
        }
        trainQueue.display(); //call to display method in PassengerQueue
    }

    public static void main (String [] args){
        launch();
    }
}

