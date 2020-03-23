import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class Companies {

    List<Company> companies;
    Gson gson = new Gson();
    Type companiesData = new TypeToken<List<Company>>(){}.getType();

    {
        try {
            companies = gson.fromJson(new FileReader(new File("src/main/resources/CompaniesData.json")), companiesData);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {

        Companies companies = new Companies();
        companies.printAllCompanies()
                .printPastDueSecurities()
                .printCompaniesBasedAfterDate("12.12.1912")
                .printCompaniesBasedAfterDate("12.05.04")
                .printCompaniesBasedAfterDate("05/12/1976")
                .printCompaniesBasedAfterDate("05/12/14")
                .printSecuritiesUsingCurrency("RUB");



    }

    public Companies printAllCompanies() {

        System.out.println(" Краткое название | Дата основания \n");
        companies.stream()
                .map(company -> String.format("%s - %s", company.getNameShort(), company.getEgrulDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))))
                .forEach(System.out::println);
        System.out.println();
        return this;

    }

    public Companies printPastDueSecurities() {
        System.out.println("Просроченные ценные бумаги: \n");
        companies.stream()
                .map(Company::getSecurities)
                .flatMap(Collection::stream)
                .filter((s) -> s.getDateTo().isBefore(LocalDate.now()))
                .map(security -> String.format(" %s , %s , %s ", security.getCode(),security.getDateTo(), security.getNameFull()))
                .forEach(System.out::println);
        System.out.println();
        long count = companies.stream()
                .map(Company::getSecurities)
                .flatMap(Collection::stream)
                .filter(x -> x.getDateTo().isBefore(LocalDate.now()))
                .count();
        System.out.println("Общее количество: " + count);
        System.out.println();
        return this;
    }

    public Companies printCompaniesBasedAfterDate(String date) {
        System.out.println("Организации, основанные после " + date + ": \n");
        companies.stream()
                .filter(company -> company.getEgrulDate().isAfter(Company.parseDate(date)))
                .map(company -> String.format(" %s , %s ",company.getNameShort(), company.getEgrulDate()))
                .forEach(System.out::println);
        System.out.println();
        return this;

    }

    public Companies printSecuritiesUsingCurrency(String currency) {
        System.out.println("Ценные бумаги в: " + currency + "\n");
        companies.stream()
                .map(Company::getSecurities)
                .flatMap(Collection::stream)
                .filter(security -> security.getCurrency().getCode().equals(currency))
                .map(security -> String.format(" %s , %s ", security.getId(),security.getCode()))
                .forEach(System.out::println);
        System.out.println();
        return this;

    }

}
