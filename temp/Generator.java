public class Generator {
    private static final String[] assemblerDirectives= "addr al align as assert autsiz bend binary binclude block break byte case cdef cerror char check comment continue cpu cwarn databank default dint dpage dsection dstruct dunion dword edef else elsif enc end endc endf endif endm endp ends endswitch endu endweak eor error fi fill for function goto here hidemac if ifeq ifmi ifne ifpl include lbl lint logical long macro mansiz next null offs option page pend proc proff pron ptext rept rta section seed segment send shift shiftl showmac sint struct switch text union var warn weak word xl xs".split(" ");
    private static final String[] functions = "abs acos all any asin atan atan2 cbrt ceil cos cosh deg exp floor format frac hypot len log log10 pow rad random range repr round sign sin sinh size sort sqrt tan tanh trunc".split(" ");
    private static final String[] types= "address bits bool bytes code dict float gap int list str tuple type".split(" ");

    public static void main(String[] args) {
//            System.out.println("\"" + s + "(\"                          { return AssemblyTypes.FUNCTION_" + s.toUpperCase() + "; }");
        for (String x: assemblerDirectives){
            System.out.println("        highlights.put(AssemblyTypes.CONTROL_COMMAND_"+x.toUpperCase()+", CONTROL_COMMAND_KEYS);");
        }
    }
}
