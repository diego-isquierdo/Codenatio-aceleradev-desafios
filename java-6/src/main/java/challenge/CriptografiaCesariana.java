package challenge;

public class CriptografiaCesariana implements Criptografia {
    private static final String regex = "[\\w\\s]";
    private static final int indiceCripto = 3;

    @Override
    public String criptografar(String texto) {
        return criptoDescripto(texto, indiceCripto);
    }

    @Override
    public String descriptografar(String texto) {
        return criptoDescripto(texto, -indiceCripto);
    }

    static String criptoDescripto(String texto, int indice){
        validaTexto(texto);

        texto=texto.toLowerCase();
        String auxTexto = "";
        for (char c : texto.toCharArray()) {
            if (String.valueOf(c).matches(regex)) {
                if (String.valueOf(c).matches("[\\d\\s]")) {
                    auxTexto = auxTexto.concat(String.valueOf(c));
                    continue;
                }

                if ((int) c + indice > 122) c = ((char) ((97 + (int) c - 123)));
                else if ((int) c + indice < 97) c = ((char) ((122 - (96 - (int) c))));

                auxTexto = auxTexto.concat(String.valueOf((char) (c + indice)));
            }
        }
        return auxTexto;
    }

    static void validaTexto(String texto) {
        if(texto==null)throw new NullPointerException("Conteúdo Null");
        if(texto.isEmpty()) throw new IllegalArgumentException("Conteúdo Vazio");
    }
}
