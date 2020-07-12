package com.designpattern;

import java.util.Observable;
import java.util.Observer;

class WeatherData extends Observable{
	private float temp;
	private float humidity;
	private float pressure;
	
	public float getTemp() {
		return temp;
	}
	public float getHumidity() {
		return humidity;
	}
	public float getPressure() {
		return pressure;
	}
	
	public void changeMeasurment() {
		setChanged();
		notifyObservers();
	}
	
	public void setMeasurement(float temp,float humidity,float pressure) {
		this.humidity=humidity;
		this.pressure=pressure;
		this.temp=temp;
		changeMeasurment();
	}
	
	
}


class CurrentConditionDisplay implements Observer{
	private Observable observable;
	private float temp;
	private float humidity;
	
	public CurrentConditionDisplay(Observable observable) {
		// TODO Auto-generated constructor stub
		this.observable=observable;
		observable.addObserver(this);
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(o instanceof WeatherData) {
			this.temp=((WeatherData) o).getTemp();
			this.humidity=((WeatherData) o).getHumidity();
			display();
		}
		
	}
	
	public void display() {
		System.out.println("Current temp :"+temp+" and humidity : "+this.humidity);
	}
	
}




class ForcastDisplay implements Observer{
	private Observable observable;
	private float temp;
	private float humidity;
	
	public ForcastDisplay(Observable observable) {
		// TODO Auto-generated constructor stub
		this.observable=observable;
		observable.addObserver(this);
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(o instanceof WeatherData) {
			this.temp=((WeatherData) o).getTemp();
			this.humidity=((WeatherData) o).getHumidity();
			display();
		}
		
	}
	
	public void display() {
		System.out.println("Current temp :"+temp+" and humidity : "+this.humidity+"Will be a rainy day");
	}
	
}

public class ObserverPattern {
	
	public static void main(String[] args) {
		WeatherData observable = new WeatherData();
		CurrentConditionDisplay display = new CurrentConditionDisplay(observable);
		ForcastDisplay display2 = new ForcastDisplay(observable);
		observable.setMeasurement(1, 2, 3);
		observable.setMeasurement(1, 5, 3);
	}

}
