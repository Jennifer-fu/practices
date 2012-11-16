using System;

namespace FacilitatorGenerator
{
    public class RandomNumberGenerator
    {
        private int size;

        public RandomNumberGenerator(int size)
        {
            this.size = size;
        }

        public virtual int Next()
        {
            return new Random().Next(size - 1);
        }
    }
}