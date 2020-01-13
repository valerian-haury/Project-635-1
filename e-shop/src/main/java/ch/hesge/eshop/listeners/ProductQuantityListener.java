package ch.hesge.eshop.listeners;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class ProductQuantityListener implements ValueChangeListener {
    @Override
    public void processValueChange(ValueChangeEvent valueChangeEvent) throws AbortProcessingException {
        System.out.println("old: " + valueChangeEvent.getOldValue() + " - new: " + valueChangeEvent.getNewValue());
    }
}
