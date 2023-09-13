public class App {
    public static void main(String[] args) {
        int[] array = {10, 12, 13, 20};
        int elemento = 13;
        int resultado = busca_binaria_iterativa(array, elemento, 3);

        if (resultado != -1) {
            System.out.println("Elemento encontrado no indice: " + resultado);
        } else {
            System.out.println("Elemento não encontrado no array.");
        }

        int[] array1 = {10, 12, 13, 20, 18, 40};
        int elemento1 = 20;

        int resultado_rec = busca_binaria(array1, elemento1,0, 3);

        if (resultado != -1) {
            System.out.println("Elemento encontrado no indice: " + resultado_rec);
        } else {
            System.out.println("Elemento não encontrado no array.");
        }
    }


public static int busca_binaria(int dado[], int x, int inf, int sup) {
    int meio;
    if (inf> sup)
    return (-1);
    meio = (inf+ sup) / 2;
    if (x == dado[meio])
    return (meio);
    if (x < dado[meio])
    return busca_binaria(dado, x , inf, meio - 1);
    else
    return busca_binaria(dado, x , meio + 1, sup);
}

public static int busca_binaria_iterativa(int dado[], int x, int sup) {
    int inf = 0;

    while (inf <= sup) {
        int meio = (inf + sup) / 2;

        if (x == dado[meio]) {
            return meio; 
        } else if (x < dado[meio]) {
            sup = meio - 1; 
        } else {
            inf = meio + 1;
        }
    }

    return -1;
}
}

