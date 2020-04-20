package br.com.codenation.calculadora;

public class CalculadoraSalario {
    private static final double SALARIO_MINIMO = 1039.00;
    private static final double INSS_PRIMEIRO_TETO_SALARIAL = 1500.00;
    private static final double INSS_SEGUNDO_TETO_SALARIAL = 4000.00;
    private static final double IRRF_PRIMEIRO_TETO_SALARIAL = 3000.00;
    private static final double IRRF_SEGUNDO_TETO_SALARIAL = 6000.00;

	public long calcularSalarioLiquido(double salarioBase) {
        return  (Double.compare(salarioBase, SALARIO_MINIMO)>0) ? Math.round(calcularInss(salarioBase)) : 0;
	}

	private double calcularInss(double salarioBase) {
        return calcularIrrf(descontaAlicotaInss(salarioBase));
	}

	static double calcularIrrf(double salarioBase){
	    if (salarioBase<=IRRF_PRIMEIRO_TETO_SALARIAL) return salarioBase;
        return Double.compare(salarioBase, IRRF_SEGUNDO_TETO_SALARIAL)<0 ? salarioBase*0.925 : salarioBase*0.85;
    }

    static double descontaAlicotaInss(double salario){
        if (Double.compare(salario, INSS_PRIMEIRO_TETO_SALARIAL)<=0) return salario*0.92;
        if (Double.compare(salario, INSS_PRIMEIRO_TETO_SALARIAL)>0&&(Double.compare(salario, INSS_SEGUNDO_TETO_SALARIAL)<0)) return salario*0.91;
        return salario*0.89;
    }

}
