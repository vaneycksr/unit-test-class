package br.unipe.allsolution.calculadoradedescontos.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class ItemServiceStubTest {
    
    private ItemService driver;
    private ItemRepositoryStub stub;
    
    @BeforeEach
    public void setUp(){
        this.driver = new ItemService();
        this.stub = new ItemRepositoryStub();
        this.driver.setItemRepository(this.stub);
    }

    @AfterEach
    void tearDown() {
        this.driver = null;
        this.stub = null;
    }

    // TODO: 19/08/2020 falta implementar os testes 
    
}
