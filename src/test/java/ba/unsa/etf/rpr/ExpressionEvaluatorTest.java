package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ExpressionEvaluatorTest extends RuntimeException {

    @Test
    void evaluate(){
        String ex="( 1 + ( 5.4 - 2.0 ) )";

     assertEquals(4.4,ExpressionEvaluator.evaluate(ex),"Our method evaluate has an error unfortunately. We apologise for the mistakes and hope to fix it soon.");
    }
    @Test
    void evaluate1() throws RuntimeException {
        String ex="( 1 + ( 5.4 - 2.0 ) )";

        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate(ex+"%"),"The expression you have entered has illegal parameters");
    }
    @Test
    void evaluate2() throws RuntimeException{
        String ex= "{ ( 3 x 2 ) ";
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate(ex),"The expression you have entered has illegal parameters");
    }
    @Test
    void evaluate3() {
        String ex= "( ( sqrt ( 9 ) - 1 ) * ( 1 + 4 ) )";
        assertEquals(10, ExpressionEvaluator.evaluate(ex),"Our method evaluate has an error unfortunately. We apologise for the mistakes and hope to fix it soon.");
           }
    @Test
    void evaluate4() throws RuntimeException{
        String ex= "( 1 + 2 ) ) ";
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate(ex),"The expression you have entered has illegal parameters");
    }
    @Test
    void evaluate5() throws RuntimeException{
        String ex= "( 1 + 2 )";
       assertEquals(3,ExpressionEvaluator.evaluate(ex));
    }
    @Test
    void evaluate6() throws RuntimeException{
        String ex= "( 0 / 2 )";
        assertEquals(0,ExpressionEvaluator.evaluate(ex));
    }
    @Test
    void evaluate7() throws RuntimeException{
        String ex= "( 2 / 0 )";
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate(ex),"You cannot divide with 0, as it is infinity.");
    }
    @Test
    void evaluate8() throws RuntimeException{
        String ex= "";
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate(ex),"You cannot divide with 0, as it is infinity.");
    }

    @Test
    void evaluate9() {
        String ex= "( 1 + sqrt ( 9 ) )";
        assertEquals(4, ExpressionEvaluator.evaluate(ex),"Our method evaluate has an error unfortunately. We apologise for the mistakes and hope to fix it soon.");
    }
    @Test
    void evaluate10() {
        String ex= "( 1 + + sqrt ( 9 ) )";
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate(ex),"The expression you have entered has illegal parameters");
    }
    @Test
    void evaluate11() {
        String ex= "( 1 + + 9 )";
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate(ex),"The expression you have entered has illegal parameters");
    }
}