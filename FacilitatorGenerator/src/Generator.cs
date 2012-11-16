using System.Collections.Generic;
using Moq;

namespace FacilitatorGenerator
{
    public class Generator
    {
        private readonly IList<string> nameList;
        private readonly RandomNumberGenerator randomNumberGenerator;

        public Generator(RandomNumberGenerator randomNumberGenerator)
        {
            this.randomNumberGenerator = randomNumberGenerator;
            nameList = new List<string>();
        }

        public void AddPerson(string name)
        {
            nameList.Add(name);
        }

        public void Run()
        {
            if (nameList.Count < 2) throw new PersonNotEnoughException();
            int presenterIndex = randomNumberGenerator.Next();
            Presenter = nameList[presenterIndex];
            int lunchOrderIndex;
            do{
                lunchOrderIndex = randomNumberGenerator.Next();
            } while (lunchOrderIndex == presenterIndex);
            LunchOrder = nameList[lunchOrderIndex];
        }

        public string Presenter { get; private set; }

        public string LunchOrder { get; private set; }
    }
}