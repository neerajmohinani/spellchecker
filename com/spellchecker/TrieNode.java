package com.spellchecker;
import java.util.LinkedList;

/**
 * A Trie Node 
 * it has :
 * 			a char member to hold char data
 * 			a linked list of DictionaryNode to hold the children of current Node
 * 			a DictionaryNode member to hold reference of its parent
 * 			a String member to hold word it forms, (a valid one) 
 * 
 * @author Neeraj Mohinani
 * @version 1.0
 *
 */
 final class TrieNode {
	private char data; //The character on this node
	private LinkedList<TrieNode> children; //The list of children Nodes
	private TrieNode parent;
	private String word;
	
	/**
	 * starting node with null initializations
	 */
	public TrieNode() {
		this.children = new LinkedList<TrieNode>();
		this.parent = null;
	}
	
	/**
	 * initialize this node with thi char parameter and parent node provided.
	 * @param data char to be held by this node
	 * @param parent parent node for this node
	 */
	public TrieNode(char data, TrieNode parent) {
		this.data = data;
		this.children = new LinkedList<TrieNode>();
		this.parent = parent;
	}
	
	/**
	 * Checks to see if any of this Node's children match the char
	 * @param data the char to match
	 * @return the child Node or null if none found
	 */
	public TrieNode findChildNode(char data) {
		if(this.children != null) {
			for(int i = 0; i < this.children.size(); i++) {
				TrieNode child = this.children.get(i);
				if(child.data == data) {
					return child;
				}
			}
		}
		return null;
	}
	
	/**
	 * A simple way of seeing a list of characters that this node calls children
	 * @return the String to print
	 */
	public String toString() {
		String toReturn;
		if(this.children.size() > 0) {
			toReturn = "Node "+this.data+" has children:";
			for(int i = 0; i < this.children.size(); i++) {
				char child = this.children.get(i).data;
				toReturn += " "+child;
			}
			if(this.word != null) toReturn += " and gives word: "+this.word;
			toReturn += "\n";
			for(int i = 0; i < this.children.size(); i++) {
				toReturn += this.children.get(i).toString();
			}
		} else {
			toReturn = "Node "+this.data+" has no children.";
			if(this.word != null) toReturn += " and gives word: "+this.word;
			toReturn += "\n";
		}
		return toReturn;
	}
	
	/**
	 * A simple way to see representation of all parents of this node.
	 * @return string representation of all parents of this node
	 */
	public String parents() {
		String toReturn = "";
		TrieNode looking = this;
		while(looking != null) {
			toReturn = looking.data + " " + toReturn;
			looking = looking.parent;
		}
		return toReturn;
	}
	
	/**
	 * getter for all children of this node.
	 * @return LinkedList<DictionaryNode> representing children of this node.
	 */
	public LinkedList<TrieNode> getChildren() {
		return this.children;
	}
	/**
	 * getter for char in this Node
	 * @return char -data in this node
	 */
	public char getData() {
		return this.data;
	}
	/**
	 * getter for the word which ends at this node.
	 * @return String word which ends at this node, if any, otherwise null.
	 */
	public String getWord() {
		return this.word;
	}
	
	/**
	 * setter for the word which ends at this node.
	 * @param word 
	 */
	public void setWord(String word) {
		this.word = word;
	}
	/**
	 * setter for the char which is held by this node.
	 * @param data
	 */
	public void setData(char data) {
		this.data = data;
	}
	
}
