package controller;

import interfaceUI.*;

public enum UseCase{
    AREA_INICIAL(new AreaInicial(), "Area Inicial "),
	CADASTRO_CLIENTE(new CadastroCliente(), "Cadastro de clientes"), 
	CADASTRO_CARRO(new CadastroCarro(), "Cadastrar Veiculo"), 
	GERENCIAMENTO_DE_VEICULOS(new GerenciamentoVeiculos(), "Novo veiculo");
	
	
	private UseCaseController controlador;
	private String title;
	
	private UseCase(UseCaseController controller, String title) {
		this.controlador = controller;
		this.title = title;
	}
	
	public UseCaseController getController() {
		return controlador;
	}
	
	public String getTitle() {
		return title;
	}
}
