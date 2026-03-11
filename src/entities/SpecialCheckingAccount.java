package entities;

import java.time.LocalDate;

public class SpecialCheckingAccount extends Account {

	public SpecialCheckingAccount() {
		super();
	}

	public SpecialCheckingAccount(String number, LocalDate openingDate, Double balance) {
		super(number, openingDate, balance);
	}

	@Override
	protected double withdrawFee() {
		return 1.20;
	}

	@Override
	protected double accountFee() {
		return 14.00;
	}

	@Override
	protected double yield() {
		return 0.0146;
	}

	@Override
	protected double overdraft() {
		return 0.0220;
	}
	
	@Override
	protected double limitOverdraft() {
		return 4000.00;
	}

}
