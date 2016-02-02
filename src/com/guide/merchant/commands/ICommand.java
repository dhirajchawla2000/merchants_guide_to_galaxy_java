package com.guide.merchant.commands;

public interface ICommand {

	public static final String WRONG_COMMAND_MESSAGE = "I have no idea what you are talking about";

	public void execute();
}
