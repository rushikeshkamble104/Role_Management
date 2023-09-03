//package com.management.role.controller;
//
//import io.micronaut.http.MediaType;
//import io.micronaut.http.annotation.Controller;
//import io.micronaut.http.annotation.Get;
//import io.micronaut.http.annotation.Produces;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class S3EmiFetchController {
//
//    @Controller("/api")
//    public class EmiTransactionController {
//
//        private static final int NUM_DAYS = 7;
//        private static final String BASE_FOLDER = "emi_transaction_ddmmyyyy";
//
//        @Get("/generateFoldersWithLinks")
//        @Produces(MediaType.APPLICATION_JSON)
//        public List<FolderWithLinks> generateFoldersWithLinks() {
//            List<FolderWithLinks> foldersWithLinks = new ArrayList<>();
//
//            // Get the current date and time
//            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy-HH.mm.ss");
//            String formattedDate = sdf.format(new Date());
//
//            // Generate links for each day and create folder representation
//            for (int day = 1; day <= NUM_DAYS; day++) {
//                String folderName = BASE_FOLDER + "/day" + day;
//
//                String link1 = generateLink("presentation", day, formattedDate);
//                String link2 = generateLink("SI_presentation", day, formattedDate);
//                String link3 = generateLink("special_case", day, formattedDate);
//
//                FolderWithLinks folderWithLinks = new FolderWithLinks(folderName, link1, link2, link3);
//                foldersWithLinks.add(folderWithLinks);
//            }
//
//            return foldersWithLinks;
//        }
//
//        private String generateLink(String prefix, int recordCount, String formattedDate) {
//            return prefix + "-" + recordCount + "-" + formattedDate + " format";
//        }
//    }
//}
