import com.bridgelabz.CensusAnalyser;
import com.bridgelabz.CensusAnalyserException;
import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;
public class CensusAnalyserTest {
    private static final String INDIAN_CENSUS_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String INDIAN_STATE_CSV_FILE = "./src/main/resources/IndiaStateCode.csv";
    private static final String INDIAN_CENSUS_DELIMITER = "./src/main/resources/IndiaStateCensusDataDelimiter.csv";
    private static final String INDIAN_STATE_CSV_WRONG_FILE = "./src/main/resources/IndiaStateCode.txt";
    private static final String INDIAN_CENSUS_CSV_WRONG_FILE = "./src/main/resources/census.abv";

    @Test
    public void givenIndianCensusCSVFile_Returns_CorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
            Assertions.assertEquals(29, numOfRecords);

        } catch (Exception e) {
            e.printStackTrace();
        } catch (CensusAnalyserException e) {
            throw new RuntimeException(e);
        }
    }



    @Test
    public void givenIndianCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }


    @Test
    public void givenIndiaCodeData_WithWrongFileDelimiter_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_DELIMITER);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_HEADER_OR_DELIMITER, e.type);
        }
    }

    @Test
    public void givenIndianCensusData_WithWrongFileType_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensus(INDIAN_CENSUS_CSV_WRONG_FILE);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE, e.type);
        }
    }


    @Test
    public void givenIndianStateCSV_ShouldReturnExactCount() {
        try {

            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaStateData(INDIAN_STATE_CSV_FILE);
            Assertions.assertEquals(37, numOfRecords);

        } catch (Exception e) {
            e.printStackTrace();
        } catch (CensusAnalyserException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void givenIndianStateData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaStateData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIndianStateData_WithWrongHeader_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaCensusData(INDIAN_STATE_CSV_FILE);

        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_HEADER_OR_DELIMITER, e.type);
        }
    }

    @Test
    public void givenIndianstateData_WithWrongFileType_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensus(INDIAN_STATE_CSV_WRONG_FILE);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE, e.type);
        }
    }
}