package gui;

import Glovo.Order;

public class Delivery extends Thread {
	
	private Order order;
	private Main main;
	
	public Delivery(Order order, Main main) {
		this.order = order;
		this.main = main;
	}

    public void run(){
       main.printNotification("Started delivery");
       try {
    	   Thread.sleep(1000 * (int) order.getDeliveryTime().minutes);
       } catch (InterruptedException e) {
    	   main.printNotification("Error in delivery");
    	   return;
       }
       main.printNotification("Ended delivery");
       order.finishDelivery();
       main.triggerDelivery();
    }
  }
