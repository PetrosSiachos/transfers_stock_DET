# transfers_stock_DET


  STOCK OVERFLOW 
Welcome To Our ERP!
It's Nice To Meet You.


όνομα εφαρμογής: STOCK OVERFLOW
ομάδα: 
•	Πέτρος Σιάχος   (Αρχηγός)  8160203
•	Μένια Κωνσταντίνου 8180055
•	Έλενα Τζερεφού 8180131 
•	Σταμάτης Λιάκος 8180059 
•	Παναγιώτης Πετρόπουλος 8180103
•	Γιώτα Σαργέντη 8180113
•	Ευγενία Φουρλά 8180144

Σύνολο γραμμών κώδικα java: 2.215

Σύνολο commits στο github:211

η ομάδα μας παραδίδει τα εξης :

1. ένα url που θα προβάλλει τα αποτελέσματα του κώδικα java που έχουμε δημιουργήσει μέσω σελίδων html και jsp(ώστε να υλοποιηθεί ακόμα καλύτερα η γραφική διεπαφή και η εφαρμογή μας να γίνει πιο ρεαλιστική).

http://ism.dmst.aueb.gr/ismgroup28/JAVA%20II/index.html


2. ένα αρχείο .jar  που θα επεξεργάζεται τη βάση δεδομένων (inserts κτλ-δημιουργία νέων πελατών, παραγγελιών)
Το .jar δημιουργείται ωσ εξής:

Το δικό μας .jar με όνομα STOCKOVERFLOW.jar δημιουργείται ως εξής:

1ος τρόπος : Από το eclipse 
1.Φτιάχνουμε ένα Java Project.
2.Φτιάχνουμε στο src το πακέτο STOCKOVERFLOWPackage και μέσα τοποθετούμε τις κλάσεις μας
3.Πατάμε δεξί κλικ πάνω στο πακέτο STOCKOVERFLOWPackage και επιλέγουμε export-Java-Runnable JAR file
4.Στο Launch configuration βάζουμε τη main του πακέτου μας και στο export destination βάζουμε τη διεύθυνση που θέλουμε να αποθηκεύσουμε το jar στον υπολογιστη μας και ονομάζουμε το .jar
5. Επιλέγουμε την επιλογή Extract required libraries into generated και πατάμε finish.

2ος τρόπος : Eclipse (β τρόπος)
1.Φτιάχνουμε ένα Java Project.
2.Φτιάχνουμε στο src το πακέτο STOCKOVERFLOWPackage και μέσα τοποθετούμε τις κλάσεις μας
3.Πατάμε δεξί κλικ πάνω στο πακέτο STOCKOVERFLOWPackage και επιλέγουμε export-JAVA-JAR file
4.Επιλέγω Next και στη συνέχεια τικάρω το project που με ενδιαφεέρει και τα .classpath, .project
5.Ακόμη τικάρω Export generated class files and resources και Export Java source files and resources 
6.Στο export destination βάζουμε τη διεύθυνση που θέλουμε να αποθηκεύσουμε το jar στον υπολογιστη μας και ονομάζουμε το .jar
7. Στα options τικάρω μόνο το Compress the contents of the JAR file και επιλέγω Next.
8.Επιλέγω ξανά Next και στο Select the class of the application entry point :
Main class: Επιλέγω την εκτέλεση της main που θέλω να εκτελεστεί απο την αντίστοιχη κλάση και επιλέγω Finish.

3ος τρόπος : Από τη γραμμή εντολών
1.Κατεβάζουμε τις κλάσεις από το github και τις τοποθετούμε σε ένα φάκελο STOCKOVERFLOWPackage
2.Μπαίνουμε στη γραμμή εντολών (command prompt) και επιλέγω το αντίστοιχο path που με οδηγεί στο φάκελο STOCKOVERFLOWPackage
3.Εκτελώ javac *.java για να κανω compile όλες τις κλάσεις
4.Δημιουργώ ενα έγγραφο κειμένου με ονομασία manifest, και μεσα γράφω:
Main-Class: Main
"Αφήνω κενό"
5. Το αποθηκέυω στο φάκελο STOCKOVERFLOWPackage
6. Εκτελώ jar cfm STOCKOVERFLOW.jar manifest.txt *.class
7.java -jar STOCKOVERFLOW.jar



Ολόκληρος ο κώδικας που χρησημοποιήσαμε για την υλοποίηση της εφαρμογής μας βρίσκεται στο φάκελο STOCKOVERFLOW_FINAL_PARADOTEO.
 Πιο συγκεκριμένα οι κλάσεις της java μας βρίσκονται στο φάκελο : STOCKOVERFLOW_FINAL_PARADOTEO/src/STOCKOVERFLOWPackage
 
 Το Manual της εφαρμογής μας θα το βρείτε εδώ : http://ism.dmst.aueb.gr/ismgroup28/JAVA%20II/manual_stock_overflow.pdf
 
 
