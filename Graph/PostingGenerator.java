public class PostingGenerator implements MessageGenerator {
    private final ObjectMapper objectmapper;

    public PostingGenerator(ObjectMapper objectmapper) {
        this.objectmapper = objectmapper;
    }

    public MessageGeneratorResult generate(Map<String,String> parameters, Map<String,String> headers, List<Payload> payloadList, MappingHelper mappingHelper){
        String payloadBody = payloadList.get(0).body();
        Map<String,String> resolvedValueMap = mappingHelper.getGenerationResolvedValuesMap(parameters,headers,payloadList,payloadBody);

        GpostRequest gpostRequest = new GpostRequest();
        GpostsRequest gpostsRequest = new GpostsRequest();

        TransactionIdentifier transactionIdentifier = new TransactionIdentifier();
        setTransactioIdentifierForPostingRequest(headers,resolvedValueMap,transactionIdentifier);
        Posting posting = new Posting();
        TransactionInfo transactionInfo = new TransactionInfo();
        List<AccountEntry> accEntries = new ArrayList<>();
        AccountEntry debitAccountEntry = new AccountEntry();
        AccountEntry creditAccountEntry = new AccountEntry();

        setAccountEntriesForPostingReq(resolvedValueMap, transactionInfo, accEntries, debitAccountEntry, creditAccountEntry);

        posting.setAccountingEntries(accEntries);

        Debtor debtor = new Debtor();
        Creditor creditor = new Creditor();

        DebtorAccount debtorAccount = new DebtorAccount();
        CreditorAccount creditorAccount = new CreditorAccount();

        DebtorAgent debtorAgent = new DebtorAgent();
        CreditorAgent creditorAgent = new CreditorAgent();

        DebtorAgentDetails debtorAgentDetails = new DebtorAgentDetails();
        CreditorAgentDetails creditorAgentDetails = new CreditorAgentDetails();

        DebtorPartyDetails debtorPartyDetails = new DebtorPartyDetails();
        CreditorPartyDetails  creditorPartyDetails = new CreditorPartyDetails();

        UltimateCreditor ultimateCreditor = new UltimateCreditor();
        InstForNextAgent instForNextAgent = new InstForNextAgent();
        InstForCdtrAgent instForCdtrAgent = new InstForCdtrAgent();

        debtor.setName(extractFromResolvedValuesMap(resolvedValueMap,"debtorName"));
        debtor.setIdentificationOrg
    }
}
