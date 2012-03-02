JFly - Ticketfly Api Java Client
================================

Note: Just starting to put this together so it is buggy and not ready for production use.

h2. Sample

JFly jfly = JFlyFactory.getInstance(null);

PagenatedResponse<Event> events = jfly.execute(EventQueryFactory.list().withOrgId(7));

for( Event e : events){
 System.out.println( e );
 }