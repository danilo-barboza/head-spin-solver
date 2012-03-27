repositories.remote << 'http://repo1.maven.org/maven2'

desc 'dead-rabbit-solver'
define 'head-spin-solver' do
  project.group = 'br.com.danilo.headspin'
  project.version = '0.0.1'
  test.with ['org.hamcrest:hamcrest-core:jar:1.1', 'junit:junit:jar:4.9', 'info.cukes:cucumber-core:1.0.0RC20']
  package :jar, :id => 'dead-rabbit-solver'
end
