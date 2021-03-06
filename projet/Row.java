package projet;

import java.util.ArrayList;
import java.util.HashMap;

import akka.actor.ActorRef;

public class Row  {
	private int lowBound;
	private int highBound;
	private ActorRef successor;
	private int idSuccessor;
	private int idNoeud;
	private int ordreLigne;
	
	public void calculInterval(){
		lowBound=((((idNoeud+(int)java.lang.Math.pow(2, (ordreLigne+1)-1)) % ((int)java.lang.Math.pow(2, Hashtable.nbNodes)) )) % 8) ;
		highBound=((((idNoeud+(int)java.lang.Math.pow(2, (ordreLigne+1))) % (int)java.lang.Math.pow(2, Hashtable.nbNodes))) % 8);
	}
	
	public Row(int idNoeud,	int ordreLigne, ActorRef actor, int actorId) {
		super();
		this.idNoeud = idNoeud;
		this.ordreLigne = ordreLigne;
		this.calculInterval();
		this.successor=actor;
		this.idSuccessor=actorId;
	}
	

	
	public boolean inRange(int id){
		if(this.lowBound<this.highBound){
			if((id>=this.lowBound)&&(id<=this.highBound)){
				return true;
			}
		}
		else{
			if(((id>=this.lowBound)&&(id<=(Hashtable.nbNodes-1)))||((id<=this.highBound)&&(id>=0))){
				return true;
			}
		}
		
		return false;
	}


	public int getLowBound() {
		return lowBound;
	}

	public void setLowBound(int lowBound) {
		this.lowBound = lowBound;
	}

	public int getHighBound() {
		return highBound;
	}

	public void setHighBound(int highBound) {
		this.highBound = highBound;
	}

	public ActorRef getSuccessor() {
		return successor;
	}

	public void setSuccessor(ActorRef successor) {
		this.successor = successor;
	}

	public int getIdNoeud() {
		return idNoeud;
	}

	public void setIdNoeud(int idNoeud) {
		this.idNoeud = idNoeud;
	}

	public int getOrdreLigne() {
		return ordreLigne;
	}

	public void setOrdreLigne(int ordreLigne) {
		this.ordreLigne = ordreLigne;
	}
	
	public int getStart(){
		return lowBound;
	}
	
	public String toString(){
		return "lowBound :"+lowBound+" highBound : "+highBound+" idNoeud : "+idNoeud+" ordreLigne : "+ordreLigne+" sucesseur : "+successor+" idSuccesseur "+idSuccessor;
	}

	public int getIdSuccessor() {
		return idSuccessor;
	}

	public void setIdSuccessor(int idSuccessor) {
		this.idSuccessor = idSuccessor;
	}
	
	
	
	
	
	
	
}
