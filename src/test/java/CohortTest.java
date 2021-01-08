import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class CohortTest {
    Cohort emptyCohort;
    Cohort cohortWithOne;
    Cohort cohortWithMany;

    @Before
    public void setUp(){
        emptyCohort = new Cohort();
        cohortWithOne = new Cohort();
        cohortWithMany = new Cohort();

        Student fro = new Student(1, "Frodo Baggins");
        fro.addGrade(90);

        Student sam = new Student(2, "Samwise Gamgee");
        sam.addGrade(100);
        sam.addGrade(100);
        sam.addGrade(100);

        cohortWithOne.addStudent(fro);
        cohortWithMany.addStudent(fro);
        cohortWithMany.addStudent(sam);
    }

    @Test
    public void testAddStudents(){
        cohortWithMany.addStudent(new Student(3, "Meriadoc Brandybuck"));
        assertEquals("Meriadoc Brandybuck", cohortWithMany.getStudents().get(2).getName());
        cohortWithMany.addStudent(new Student(4, "Peregrin Took"));
        assertEquals(4, cohortWithMany.getStudents().size());
    }

    @Test
    public void testGetStudents(){
        assertEquals(0, emptyCohort.getStudents().size());
        assertEquals(1, cohortWithOne.getStudents().size());
        assertEquals(1, cohortWithMany.getStudents().get(0).getId());
        assertEquals(2, cohortWithMany.getStudents().get(1).getId());
    }

    @Test
    public void testAverage(){
        assertEquals(Double.NaN, emptyCohort.getCohortAverage(), 0);
        assertEquals(90.0, cohortWithOne.getCohortAverage(), 0);
        assertEquals(95.0, cohortWithMany.getCohortAverage(), 0);
    }
}
