package com.pamokos.db.aktoriai;



import java.sql.DriverManager;

import java.sql.*;

import java.util.Scanner;



/**

 * Created by A on 2017.03.14.

 */

public class papildomos {

    private Connection connection;

    Scanner sc = new Scanner(System.in);



    public papildomos() {

        try {

            connection = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/aktoriai",

                    "root",

                    ""

            );

            //Statement statementnt = connection.createStatement();

        } catch (Exception klaida) {

            System.out.println(klaida);



        }

    }



    public void Pasisveikinimas() {

        System.out.println("Sveiki, pasirinkite ka norite padaryti 'aktoriai' lenteleje");

    }



    public void Paklausimas() {

        System.out.println("Norint ivesti duomenis pasirinkti '1', norint trinti, pasirinkti '2', norint peržiūrėti lentelę, pasirinkti '3'");

    }



    public void Pasirinkimas() {

        int pasirinkimas = sc.nextInt();

        switch (pasirinkimas) {



            case 1:

                Insertas();

                break;

            case 2:

                Deletinimas();

                break;

            case 3:

                lentele();

                break;

        }



    }



    public void Insertas() {





        try {



            PreparedStatement statement = connection.prepareStatement("INSERT INTO `aktoriai` (`vardas`, `pavarde`, `amzius`) VALUES (?, ?, ?)");

            System.out.println("Ivesti Varda");

            String name = sc.next();

            System.out.println("Ivesti Pavarde");

            String surname = sc.next();

            System.out.println("Ivesti Amžių");

            String phone = sc.next();

            statement.setString(1, name);

            statement.setString(2, surname);

            statement.setString(3, phone);




            statement.executeUpdate();





        } catch (Exception klaida) {

            System.out.println(klaida);

        }



    }



    private void Deletinimas() {

        try {

            System.out.println("Ivesti ID aktoriaus kuri norite istrinti");

            int id = sc.nextInt();

            PreparedStatement statement = connection.prepareStatement("DELETE FROM `aktoriai` WHERE `aktoriai`.`id` = " + id + ";");

            statement.executeUpdate();



        } catch (Exception klaida) {

            System.out.println(klaida);

        }



    }
    private void lentele() {

        try {

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM `aktoriai`;");

            while (resultSet.next()) {

                System.out.print(resultSet.getInt("id"));

                System.out.print("|");

                System.out.print(resultSet.getString("vardas"));

                System.out.print("|");

                System.out.print(resultSet.getString("pavarde"));

                System.out.print("|");

                System.out.print(resultSet.getInt("amzius"));

                System.out.print("|");
                System.out.println("");


            }

        } catch (Exception klaida) {

            System.out.println(klaida);

        }



    }





}
