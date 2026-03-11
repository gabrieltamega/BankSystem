package entities;

import java.time.LocalDate;

public class PremiumCheckingAccount extends Account {

	public PremiumCheckingAccount() {
		super();
	}

	public PremiumCheckingAccount(String number, LocalDate openingDate, Double balance) {
		super(number, openingDate, balance);
	}

	@Override
	protected double withdrawFee() {
		return 0.00;
	}

	@Override
	protected double accountFee() {
		return 32.00;
	}

	@Override
	protected double yield() {
		return 0.0187;
	}

	@Override
	protected double overdraft() {
		return 0.0210;
	}
	
	@Override
	protected double limitOverdraft() {
		return 10000.00;
	}

}
