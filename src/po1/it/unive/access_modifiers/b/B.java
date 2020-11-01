package po1.it.unive.access_modifiers.b;

import po1.it.unive.access_modifiers.a.A;

public class B {
    private int b_private;

    void foo(A a, B b, B1 c) {
        //int numero = a.a_public; v
        //int numero = a.a_default; x
        //int numero = a.a_private; x

        //int numero = this.b_private; v
        //int numero = b.b_private; v

        //int numero = c.b1_public; V
        //int numero = c.b1_default;V
        //int numero = c. b1_private; x
    }
}
