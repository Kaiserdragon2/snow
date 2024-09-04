package helper;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class ChangelogHelper {
    public static void main(String[] args) {
        //String
        String rootDir = System.getProperty("user.dir");
        // Get the path of the root directory
        Path rootPath = Paths.get(rootDir);
        // Get the name of the root directory
        String rootDirName = rootPath.getFileName().toString();
        if (rootDirName.equals("preparehelper")) {
            rootDir = "..";
        }
        String sourceDir = rootDir + "/icons/white";
        String resDir;
        String destDir;
        String xmlDir;
        String newXML;
        String categoryGamesXml;
        String assetsDir;
        String appFilter;
        String MDChangelog = rootDir + "/generated/changelog.md";

        String markdownFilePath = MDChangelog;

        try {
            // Read the content of the Markdown file
            String markdownContent = new String(Files.readAllBytes(Paths.get(markdownFilePath)));

            // Create a parser and renderer
            Parser parser = Parser.builder().build();
            HtmlRenderer renderer = HtmlRenderer.builder().build();

            // Parse the Markdown content
            Node document = parser.parse(markdownContent);

            // Render the document to HTML
            String htmlContent = renderer.render(document);

            // Output the HTML content
            System.out.println(htmlContent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
