
package negocio;

public class CalculoCotizacion {
    float valorCotizacion;
    float montoPesos;
    float montoDolares;
    
    public CalculoCotizacion(){}

    public float getValorCotizacion() {
        return valorCotizacion;
    }
    public void setValorCotizacion(float valorCotizacion) {
        this.valorCotizacion = valorCotizacion;
    }
    public float getMontoPesos() {
        return montoPesos;
    }
    public void setMontoPesos(float montoPesos) {
        this.montoPesos = montoPesos;
    }
    public float getMontoDolares() {
        return montoDolares;
    }
    public void setMontoDolares(float montoDolares) {
        this.montoDolares = montoDolares;
    }
    
    public float calculoDolarAPeso(){
        return montoDolares*valorCotizacion;
    }
    
    public float calculoPesoADolar(){
        return montoPesos/valorCotizacion;
    }
    
    
    
    
    
    
}
