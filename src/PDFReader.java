import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PDFReader {

    public static void main(String[] args) {

        // PDF retrieval parameters
     String outputFilePath = "C:\\Users\\Ghalem\\Desktop\\output.pdf";
        int memoireIdToRetrieve = 6; // Replace with the actual ID of the memoire you want to retrieve

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/porjet_ihm", "ihm", "ihm");

            // Prepare the SQL statement to retrieve PDF content
            String sql = "SELECT pdfContent FROM memoire WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, memoireIdToRetrieve);

                // Execute the query
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        // Retrieve the PDF content from the result set
                        byte[] pdfContent = resultSet.getBytes("pdfContent");

                        // Save the PDF content to a local file
                        savePDFToFile(pdfContent, outputFilePath);
                        System.out.println("PDF content successfully retrieved and saved to " + outputFilePath);
                    } else {
                        System.out.println("No PDF content found for memoire ID: " + memoireIdToRetrieve);
                    }
                }
            }

            // Close the database connection
            connection.close();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void savePDFToFile(byte[] pdfContent, String filePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(pdfContent);
        }
    }
}
